Best article :


https://www.hivemq.com/blog/mqtt-essentials-wrap-up/  -- Topic wise


https://www.hivemq.com/blog/mqtt-security-fundamentals-wrap-up/  -- Security topic wise

https://www.hivemq.com/blog/mqtt-essentials-part-1-introducing-mqtt/

https://www.hivemq.com/blog/are-your-mqtt-applications-resilient-enough/#reconnect  --summary features

https://www.hivemq.com/blog/mqtt-client-library-paho-python/   -- Python client example


https://www.hivemq.com/blog/introducing-the-mqtt-security-fundamentals/

https://www.youtube.com/watch?v=LKz1jYngpcU

http://www.steves-internet-guide.com/mqtt/ -->vg

https://www.baeldung.com/kafka-connect-mqtt-mongodb

With the Internet surviving for such a long time using the HTTP protocol, you might ask yourself why you would ever need another protocol. Well, HTTP is great for doing a request and getting a response, like when a client want to ask a server for some information, and get an answer back. But it doesn't really have a good solution when a source of information should push a change to many clients, and there is no built-in support for quality of service. The text-based format of HTTP requires more bandwidth, and any device that wants to act as a host needs to have a web server installed. Keeping a web server alive to answer incoming requests takes a lot of battery power, which is a scares resource on any "thing".

So, let me introduce the Message Queuing Telemetry Transport (MQTT), which is a protocol that can solve many of these problems. First of all it uses a publish-subscribe messaging pattern, which means that any source of information (such as a sensor) can publish its data, and then any client can subscribe to that data. All this is happening in a broker that keeps track of all publications and subscriptions, so when a publisher sends an update with new data (publish a message), the broker takes care of sending the new data to all subscribers. The built-in support for quality of service means that the broker can guarantee delivery of a message, e.g. that it's delivered at least one time or exactly once. MQTT is a binary format that requires a minimum of bandwidth (the fixed header is only two bytes), and it also has a small implementation footprint that require less battery. Both of these efficient aspects can make MQTT scale very well, and that is important when we are talking about millions of "things". It's not as established as HTTP, but it's standardized by OASIS and backed by IBM.

--> bidirectional 


To see how it works, let's set up an MQTT broker, and I have selected mosquitto, which is the most famous open source MQTT broker. I will set it up on a cloud server with Ubuntu (12.04 LTS), and to get one of your own, please see my video "Omnichannel Services – Cloud Server". Start by connecting to the server (replace AwsKeyPar.pem with your key file, and 0.0.0.0 with the IP address of your server)...

ssh -i AwsKeyPair.pem ubuntu@0.0.0.0

...and then install and run mosquitto using the following commands:

sudo apt-add-repository ppa:mosquitto-dev/mosquitto-ppa
sudo apt-get update 
sudo apt-get install mosquitto
sudo apt-get install mosquitto-clients
mosquitto

Now open a new terminal window, connect to the server (see ssh command above) and enter the command:

mosquitto_sub -d -t hello/world

This starts a subscription to the topic "hello/world". Now open yet another terminal window, connect to the server, and enter the command:

mosquitto_pub -d -t hello/world -m "This is my first message"

This will publish a first message on the topic "hello/world", and it should appear in the second terminal windows where you set up the subscription.

So there you have your mosquitto MQTT broker running.

With that I hope you understand what MQTT is and why you need it to build efficient and scalable solutions for the Internet of Things.


### Tools

Scaling MQTT Using Kafka - Tim Kellogg
https://www.youtube.com/watch?v=VoTclkxSago

Apache Kafka + MQTT IoT Integration (via Kafka Connect / Confluent Proxy)
https://www.youtube.com/watch?v=L38-6ilGeKE

https://www.confluent.io/kafka-summit-sf18/processing-iot-data-from-end-to-end


http://www.kai-waehner.de/blog/2018/09/10/apache-kafka-mqtt-end-to-end-iot-integration-demo-scripts-github/

https://github.com/kaiwaehner/kafka-connect-iot-mqtt-connector-example

https://github.com/kaiwaehner/ksql-udf-deep-learning-mqtt-iot

https://www.hivemq.com/blog/streaming-iot-data-and-mqtt-messages-to-apache-kafka/ --> very good
https://www.infoq.com/news/2019/04/hivemq-extension-kafka-mqtt/ --> vg
#### Mosquitto
https://pastebin.com/Etn59ppp
http://www.steves-internet-guide.com/install-mosquitto-linux/

https://behindthesciences.com/coding/how-to-install-mqtt-broker-on-aws-for-free/
https://aws.amazon.com/blogs/iot/how-to-bridge-mosquitto-mqtt-broker-to-aws-iot/

https://medium.com/@achildrenmile/mqtt-broker-on-aws-ec2-hands-on-install-configure-test-out-f12dd2f5c9d0



The source needs to be a CIDR block or a Security Group ID


The server
The server listens on the following ports:

1883 : MQTT, unencrypted
8883 : MQTT, encrypted
8884 : MQTT, encrypted, client certificate required
8080 : MQTT over WebSockets, unencrypted
8081 : MQTT over WebSockets, encrypted

- Run the following two commands:
```
		sudo apt-get update
		sudo apt-get install mosquitto mosquitto-clients
```

- Enable remote access :
The default MQTT configuration only allows connections from localhost. To be able to use the broker to subscribe and publish messages from a remote machine, we need to open port 1883 in the config file. Open the config file:
```
		sudo nano /etc/mosquitto/conf.d/default.conf
		Add following line : 
		listener 1883
```
	
- Password Protect your MQTT Broker :

```
sudo mosquitto_passwd -c /etc/mosquitto/passwd usename
```

Replace "usename" with your own username.You will then be prompted to enter a password. 

Edit the config file to add passwd file :
```
sudo nano /etc/mosquitto/conf.d/default.conf
```
Add the following lines in the config file and save it.
```
	allow_anonymous false
	password_file /etc/mosquitto/passwd
```
One important thing to keep in mind is that lines must be following each other without blank lines after the listener directive.

- Restart the MQTT Broker :
```
sudo service mosquitto stop

sudo service mosquitto start

sudo service mosquitto status
```
- Send mesg
```
mosquitto_pub -h localhost -t "test" -m "hello world" -u "gdciot" -P "gdciot"
```

- Recieve mesg
```
mosquitto_sub -h localhost -t test -u "gdciot" -P "gdciot"
```

- Debug :

Test connection from windows/PShell
Test-NetConnection 18.222.145.136 -Port 1883

To test it is running use command:

netstat –at 


ssl
https://primalcortex.wordpress.com/2016/03/31/mqtt-mosquitto-broker-with-ssltls-transport-security/

http://blog.yatis.io/install-secure-robust-mosquitto-mqtt-broker-aws-ubuntu/


#### MQTT.fx
https://blogs.sap.com/2017/11/14/using-mqtt.fx-as-the-mqtt-simulation-tool-to-post-mqtt-messages-to-iot-service-4.0/


#### paho
https://www.eclipse.org/paho/

https://iot.eclipse.org/getting-started/#sandboxes

https://devopedia.org/mqtt

#### Node Red
####

#### Advance Concepts 

##### Birth message

##### Close or "Death" message

##### will message

##### Testament message

##### Retain Topics

Dynamic topics

##### Wild Cards

##### QOS ( delivery guarantee i.e 0,1,2)
The MQTT Broker supports all the standard QoS as per the MQTT Specifications. 
QoS 0 – Atmost Once (“Fire and forget”)
QoS 1 – Atleat Once 
QoS 2 – Exactly Once

https://www.sam-solutions.com/blog/internet-of-things-iot-protocols-and-connectivity-options-an-overview/



#### Usecase :
OBD sensor integration with MQTT 
https://www.makeuseof.com/tag/obd-ii-port-used/

The OBD-II(On-board diagnostics) on-board computer features a 16-pin port located under the driver’s side dash.

There are five basic signal protocols:
SAE J1850 PWM: Pulse Width Modulation, used in Ford vehicles
SAE J1850 VPW: Variable Pulse Width used in General Motors vehicles
ISO9141-2: Used in all Chrysler and a variety of European or Asian vehicles
ISO14230-4 (KWP2000): Keyword Protocol, used in a variety of European and Asian imports as well as Honda, Jeep, Land Rover, Subaru, Mazda, Nissan, and more
ISO 15765 CAN: Controller Area Network, used on all vehicles manufactured after 2008

https://www.hivemq.com/blog/are-your-mqtt-applications-resilient-enough/#reconnect

https://www.hivemq.com/blog/mqtt-client-library-paho-python/

https://www.hivemq.com/blog/mqtt-essentials-part-1-introducing-mqtt/ 

https://stackoverflow.com/questions/50714883/handling-backpressure-data-tranmission-in-mqtt-client


https://github.com/BirchJD/PiOBDII

#### Raspberry Setup 

https://www.youtube.com/watch?v=aL1pWI2K60w

https://www.youtube.com/watch?v=aL1pWI2K60w

https://www.youtube.com/watch?v=gOLnIrqmPQc


https://www.balena.io/etcher/

change of config after login -- headless

sudo raspi-config

Change password, expand filesystem

SETUP FOR RASPBIAN PIXEL DESKTOP
And in "Advanced Option" or “Interfacing Options”--> 
Enable VNC

Then go to browser :
 IP:5800/5900

Changing resolution:

sudo nano /boot/config.txt

hdmi_force_hotplug=1
hdmi_ignore_edid=0xa5000080
hdmi_group=2
hdmi_mode=85

 


Scan IP 
https://angryip.org/download/#windows


Remote desktop :
VNC

https://www.youtube.com/watch?v=gM5Qs_YHcRg



https://www.youtube.com/watch?v=2HXHj3g6pb0

https://www.realvnc.com/en/

Older versions of Raspbian don’t include RealVNC, but we can install a similar service called XRDP that works well too.

https://www.youtube.com/watch?v=OE2FC1aSAqM

lanscan --

raspberrypi

pi@192.168.43.75

-----------------------------
cat /etc/wpa_supplicant/wpa_supplicant.conf
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
country=IN

network={
        ssid="NETGEAR-Guest"
        psk="GuestPassword123"
        key_mgmt=WPA-PSK
}

network={
        ssid="OnePlus 6T"
        psk="Password"
        key_mgmt=WPA-PSK
}

network={
        ssid="rds"
        psk="test1234"
        key_mgmt=WPA-PSK
}

network={
        ssid="TP-Link_A58C"
        psk="84415059"
        key_mgmt=WPA-PSK
}


----------------------------------
sudo shutdown -h now (or sudo halt) OR
sudo shutdown -r now (or sudo reboot)