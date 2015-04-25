##前言
JGroups是一个开源的纯java编写的可靠的群组通讯工具。其工作模式基于IP多播，但可以在可靠性和群组成员管理上进行扩展。其结构上设计灵活，提供了一种灵活兼容多种协议的协议栈。

JGroups 多线程的方式实现了多个协议之间的协同工作，常见工作线程有心跳检测，诊断等等。

JGroups实现多机器之间的通信一般都会包含维护群组状态、群组通信协议、群组数据可靠性传输这样的一些主题。

JGroups群组的各个节点是存在"管理节点"的，至少可以说某个节点提供了在一段时间内维护状态信息和消息可靠性检测的功能(一般是最先启动的节点)。

目前Jboss、Ecache的分布式缓存是基于Groups通信。

若JGroups通信基于Udp，则可能需要开启机器上UDP相关的设置，比如Open udp。

* 温馨提示：JGroups各个协议相关的配置文件都可以从JGroups-x.x.x.Final.jar中找到。

##JGroups 资料

> http://www.jgroups.org/tutorial/index.html(官网)
> http://sourceforge.net/projects/javagroups/(JGroups工程&讨论组(Discussion))

##tcp/ip与udp协议

通常我们都知道tcp和udp最大的区别在于可靠性，tcp是基于可靠连接的传输，udp则属非可靠连接，具体可参考百度百科(http://baike.baidu.com/view/1161229.htm?fr=aladdin)。

JGroups当中，udp是比较推荐的通信方式，其特点是不需要知道另一个节点的ip，通过多播网络发现就可以“找到”相应的节点，而tcp则需要在配置文件中固定配置。

###tcp模式

> 如果是同一台机器测试,请注意在
TCPPING 元素下修改 initial_hosts的配置端口
例如
> 
	"${jgroups.tcpping.initial_hosts:192.168.1.100[7800],192.168.1.100[7801]}
如果是多台机器测试,请注意在 TCPPING 元素下修改 initial_hosts 的ip,端口随意
 例如
> 
	"${jgroups.tcpping.initial_hosts:192.168.1.100[7800],192.168.1.112[7800]}

###udp模式

> 同一台机器的不同端口(端口是动态的)可通信.
> 不同机器之间的ip多播可能会受到一些因素限制而造成节点之间无法彼此发现.

###JGroups的可靠性
> 
1，对所有接收者的消息的无丢失传输（通过丢失消息的重发）
> 
2，大消息的分割传输和重组
> 
3，消息的顺序发送和接收
> 
4，原子性：消息要么被所有接收者接收，要么全不

###JavaGroups的成员关系管理
> 
1，可以知道组内有哪些成员
>
2，成员的加入，离开，掉线等的通知

###JavaGroups的主要功能特征

- 组的创建与删除。组成员能在LAN或WAN环境内互相发送消息
- 组的成员加入或离开
- 组成员的检测和通知：加入，离开，掉线
- 检测与移除已掉线的成员
- 消息的组播 (member-to-group或point-to-multipoint)
- 消息的点对点发送 (member-to-member或point-to-point)
- 支持UDP (IP Multicast), TCP, JMS等传输协议



##基本概况

在JGroups中JChannel类提供了主要的API ，用于连接到集群（cluster）、发送和接收消息（Message）和注册listeners等。以相同name调用JChannel.connect(String name)方法的所有实例会连接到同一个集群。

Message包含消息头（保存地址等信息）和一个字节数组（保存希望传输的数据）。

org.jgroups.Address接口及其实现类封装了地址信息，它通常包含IP地址和端口号。

连接到集群中的所有实例（instance）被称为一个视图（org.jgroups.View）。通过View.getMembers()可以得到所有实例的地址。实例只有在连接到集群后才能够发送和接收消息。

当实例希望离开集群时，可以调用JChannel.disconnect()方法。当希望释放占有的资源时，可以调用JChannel.close()方法。JChannel.close()方法内部会调用JChannel.disconnect()方法。

通过调用JChannel.setReceiver()方法可以接收消息和得到View改变的通知。每当有实例加入或者离开集群的时候，viewAccepted(View view)方法会被调用。View.toString()方法会打印出View中所有实例的地址，以及View ID。

> - 注意的是，每次viewAccepted(View view)方法被调用时，view参数都不同，其View ID也会增长。如果没有名字，名字是机器名+随机数，后面跟|，以及自增长的View ID。View内的第一个实例被称为coordinator。
    
Receiver接口上的getState()，setState()方法用于在实例间传递状态。新的实例通过setState()方法获得通过状态，而这个状态是通过调用集群中其它某个实例上的getState()获得的。

##jgroups的应用
jgroups可以用来做state replication

以下项目场景都使用了jgroups

* JBoss Application Server Clustering
* OSCache Clustering
* Jetty HTTP session replication
* Tomcat HTTP session replication