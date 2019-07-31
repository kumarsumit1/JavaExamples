
#In this lesson we will investigate methods for the exploration of 
# data using visualization techniques. We will use several 
# Python packages to create the visualizations, matplotlib, Pandas
#  plotting, and seaborn. For these lessons we will be working 
# with a data set containing the prices and characteristics of a 
# number of automobiles. The ultimate goal is to build a model 
# for predicting the price of a car from its characteristics.
from IPython.display import Image, display
def read_auto_data(fileName = "Automobile price data.csv"):
    'Function to load the auto price data set from a .csv file' 
    import pandas as pd
    import numpy as np

    ## Read the .csv file with the pandas read_csv method
    auto_prices = pd.read_csv(fileName)
    
    ## Remove rows with missing values, accounting for mising values coded as '?'
    cols = ['price', 'bore', 'stroke', 
          'horsepower', 'peak-rpm']
    for column in cols:
        auto_prices.loc[auto_prices[column] == '?', column] = np.nan
    auto_prices.dropna(axis = 0, inplace = True)

    ## Convert some columns to numeric values
    for column in cols:
        auto_prices[column] = pd.to_numeric(auto_prices[column])
#    auto_prices[cols] = auto_prices[cols].as_type(int64)
        
    return auto_prices
auto_prices = read_auto_data()


#Using the Pandas head method let's have a first look at the columns in this data set.
display(auto_prices.head())

#You can see there are both numerical and string (categorical) variable types. 
# As a next step examine some summary statistics of the numeric columns 
# using the Pandas describe method. 
display(auto_prices.describe())

#Basic chart types

#Now that we have loaded and had a first look at the data, let's get to work making some charts.

#There are enumerable chart types that are used for data exploration. 
# In this tutorial we focus on the most used chart types:
#    Scatter plot
#    Line plots
#    Bar plots
#    Histograms
#    Box plots
#    Kernel Density Estimation Plots
#    Violin plots



# Scatter plots

#Scatter plots show the relationship between two variables in the form of dots on the plot. 
# In simple terms, the values along a horizontal axis are plotted against a vertical axis.
#Scatter plots with Matplotlib

#Matplotlib is at the base of most Python plotting packages. 
# Some basic understanding of Matplotlib will help you achieve better control of your graphics.

#Let's start by making a simple scatter plot. Our recipe is simple:
#  Steps :
#    Import Matplotlib.pyplot
#    Use the plot method.
#    Specify the values to plot on the x and y axes.
#    Specify that we want red dots using a type of 'ro'. If you do not specify a type, you will get a line plot which is the default.

#Exectute the code in the cell below to create a scatter plot of city mpg vs. auto price.



import matplotlib.pyplot as plt
# %matplotlib inline 
plt.plot(auto_prices['city-mpg'], auto_prices['price'], 'ro')

#Scatter plots with Pandas

#While you can create most any visualization using Matplotlib, 
# with enough code, you may want a simpler approach if your data are in a Pandas data frame.
# The Pandas package contains a number of useful plot methods which operate on data frames. The simple recipe for plotting from Pandas data frames is:
#  Steps :
#   Use the plot method, specifing the kind argument, or use a chart-specific plot method.
#   Specify the columns with the values for the x and y axes.

auto_prices.plot(kind = 'scatter', x = 'city-mpg', y = 'price')



#The Pandas plotting method provides some nice improvements compared 
# to the basic Matplotlib plot. Namely, the axes are scaled a bit better, 
# so that points are not cut off, and some sensible axis labels are generated.

# Excercise : In the cell below create and exectue code to plot auto price vs curb weight.

auto_prices.plot(kind = 'scatter', x = 'curb-weight', y = 'price')

#We can take advantage of the fact that Pandas plot methods are built on matplotlib. Thus, we can specify a figure and one or more axes within that figure. Then, we can control many plot attributes once we have specified the axes. Our improved recipe looks like this:

#    Specify a figure, including a size.
#    Define one or more axes within the figure.
#    Use the pandas plot method of choice. Make sure you specify the axis you are using.
#    Use methods on the axes to control and add attributes like titles and axis labels.

import matplotlib.pyplot as plt
fig = plt.figure(figsize=(6, 6)) # define plot area
ax = fig.gca() # define axis                   
auto_prices.plot(kind = 'scatter', x = 'city-mpg', y = 'price', ax = ax)
ax.set_title('Scatter plot of price vs MPG') # Give the plot a main title
ax.set_xlabel('City MPG') # Set text for the x axis
ax.set_ylabel('Auto Price')# Set text for y axis

#In the plot above, we can see that the most costly cars have the lowest fuel efficiency, whereas relatively inexpensive cars are also more economical to drive.

# Excercise : ceate and execute the code required to display an improved version of the plot you created in the pervious exercise. Specify the plot size, and make sure to include axis lables and a main title.


# Line plots

# Line plots are similar to point plots. In line plots the discrete points are connected by lines.

# First, we will create a dataframe, with a simple relationship between x and y.

import pandas as pd
x = list(range(100))
y = [z * z for z in range(100)]
df = pd.DataFrame({'x':x, 'y':y})

#Now, apply the previous recipe to plot x vs y as a line chart.

fig = plt.figure(figsize=(5, 5)) # define plot area
ax = fig.gca() # define axis                   
df.plot(x = 'x', y = 'y', ax = ax) ## line is the default plot type
ax.set_title('Line plot of x^2 vs. x') # Give the plot a main title
ax.set_xlabel('x') # Set text for the x axis
ax.set_ylabel('x^2')# Set text for y axis


# Bar plots

# Bar plots are used to display the counts of unique values of a categorical variable. The height of the bar represents the count for each unique category of the variable.

# It is unlikely that your pandas data frame includes counts by category of a variable. Thus, the first step in making a bar plot is to compute the counts. Fortunately, pandas has a value_counts method. The code below uses this method to create a new data frame containing the counts by make of the car.

counts = auto_prices['make'].value_counts() # find the counts for each unique category

display(counts)

# Notice that this data frame/series has many fewer rows than the original,
# since it only needs one row for each unique value of the make.

# Now, create the bar plot of number of autos by make using the counts data frame, by executing the code in the cell below. Notice, that the recipe for this chart is the same as we have used for scatter plots and line plots, just using the .plot.bar method.

fig = plt.figure(figsize=(8,8)) # define plot area
ax = fig.gca() # define axis    
counts.plot.bar(ax = ax) # Use the plot.bar method on the counts data frame
ax.set_title('Number of auto types by make') # Give the plot a main title
ax.set_xlabel('Make') # Set text for the x axis
ax.set_ylabel('Number of autos')# Set text for y axis

# Histograms

# Histograms are related to bar plots. Histograms are used for numeric variables. Whereas, a bar plot shows the counts of unique categories, a histogram shows the number of data with values within a bin. The bins divide the values of the variable into equal segments. The vertical axis of the histogram shows the count of data values within each bin.

# The code below follows our same basic recipe to create a histogram of engine-size. Notice however, that the column of the data frame we wish to plot is specified by name as auto_prices['engine-size'].

fig = plt.figure(figsize=(8,8)) # define plot area
ax = fig.gca() # define axis    
auto_prices['engine-size'].plot.hist(ax = ax) # Use the plot.hist method on subset of the data frame
ax.set_title('Histogram of auto engine size') # Give the plot a main title
ax.set_xlabel('Engine size') # Set text for the x axis
ax.set_ylabel('Number of autos')# Set text for y axis

# The histogram shows that the distibution of engine size is skewed toward small engines. There are also a few autos with very large engines, which appear as outliers.

# Box plots

# Box plots, also known as box and wisker plots, were introduced by John Tukey in 1970. Box plots are another way to visualize the distribution of data values. In this respect, box plots are comparable to histograms, but are quite different in presentation.

# On a box plot the median value is shown with a dark bar. The inner two quartiles of data values are contained within the 'box'. The 'wiskers' enclose the majority of the data (up to +/- 2.5 * interquartile range). Outliers are shown by symbols byond the wiskers.

# Several box plots can be stacked along an axis for comparison. The data are divided using a 'group by' operation, and the box plots for each group are stacked next to each other. In this way, the box plot allows you to display two dimensions of your data set.

# The code in the cell below generally follows the recipe we have been using. The data frame is subsetted to two columns. One column contains the numeric values to plot and the other column is the group by variable. In this case, the group by variable is specified with the by = 'fuel-type' argument.

fig = plt.figure(figsize=(8,8)) # define plot area
ax = fig.gca() # define axis    
auto_prices[['engine-size','fuel-type']].boxplot(by = 'fuel-type', ax = ax) # Use the plot.bar method on the new data frame
ax.set_title('Box plots of auto engine size by fule type') # Give the plot a main title
ax.set_xlabel('Fuel type') # Set text for the x axis
ax.set_ylabel('Engine size')# Set text for y axis



# Examine the plot above and notice the differences in the distribution of engine size by fuel type. 
# There is considerable overlap in the inter-quartile range (the range within the boxes), 
# with gas cars having generally smaller engines. The median engine size (the red bar) for 
# gas cars is noticeably lower than for diesel cars. However, the range of engine sizes for gas cars is greater,
#  including a few outliers. It is likely, these are the outliers we saw in the histogram.