你好，GIT！！！

JGroups 入门实践
    前言

        JGroups是一个开源的纯java编写的可靠的群组通讯工具。其工作模式基于IP多播，但可以在可靠性和群组成员管理上进行扩展。其结构上设计灵活，提供了一种灵活兼容多种协议的协议栈。

        JGroups 多线程的方式实现了多个协议之间的协同工作，常见工作线程有心跳检测，诊断等等。

        JGroups实现多机器之间的通信一般都会包含维护群组状态、群组通信协议、群组数据可靠性传输这样的一些主题。

        JGroups群组的各个节点是存在"管理节点"的，至少可以说某个节点提供了在一段时间内维护状态信息和消息可靠性检测的功能(一般是最先启动的节点)。

        目前Jboss、Ecache的分布式缓存是基于Groups通信。

        若JGroups通信基于Udp，则可能需要开启机器上UDP相关的设置，比如Open udp。

        温馨提示：JGroups各个协议相关的配置文件都可以从JGroups-x.x.x.Final.jar中找到。

    JGroups 资料

         http://www.jgroups.org/tutorial/index.html(官网)

         http://sourceforge.net/projects/javagroups/(JGroups工程&讨论组(Discussion))

    JGroups 入门示例

        1,节点通信(tcp/ip,udp)方式.

        2,通道和消息传送.

        3,节点状态同步.

    tcp/ip与udp协议

        通常我们都知道tcp和udp最大的区别在于可靠性，tcp是基于可靠连接的传输，udp则属非可靠连接，
        具体可参考百度百科(http://baike.baidu.com/view/1161229.htm?fr=aladdin)。

        JGroups当中，udp是比较推荐的通信方式，其特点是不需要知道另一个节点的ip，通过多播网络发现就可以“找到”相应的节点，而tcp则需要在配置文件中固定配置。