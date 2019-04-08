// This file must be implemented when completing activity 2
//

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//
// Chat Robot
//
//
public class ChatRobot
        implements MessageListener {
    private ChatConfiguration conf;
    private IChatServer server = null;
    private IChatUser myUser = null;

    public ChatRobot(ChatConfiguration conf) {
        this.conf = conf;
    }

    private void doConnect() throws Exception {
        try {
            Registry reg = LocateRegistry.getRegistry(conf.getNameServiceHost(), conf.getNameServicePort());
            server = (IChatServer) reg.lookup(conf.getServerName());
        } catch (RemoteException e) {
            throw new Exception("rmiregistry not found at '" + conf.getNameServiceHost() + ":" +
                    conf.getNameServicePort() + "'");
        } catch (NotBoundException e) {
            throw new Exception("Server '" + conf.getServerName() + "' not found.");
        }

        myUser = new ChatUser("bot#" + this.hashCode(), this);
        if (!server.connectUser(myUser))
            throw new Exception("Nick already in use");

        IChatChannel[] channels = server.listChannels();
        if (channels == null || channels.length == 0)
            throw new Exception("Server has no channels");
        for (IChatChannel channel : channels) {
            channel.join(myUser);
        }

        System.out.println("Joined all channels. Ready!");
    }

    @Override
    public void messageArrived(IChatMessage msg) {
        try {
            if (msg.getText().equals("JOIN .*")) {
                IChatChannel channel = server.getChannel(conf.getChannelName());
                IChatMessage message = new ChatMessage(myUser, channel,
                        "Hola " + msg.getText().substring(ChatChannel.JOIN.length() + 1));
                channel.sendMessage(message);
            }
        } catch (RemoteException e) {
            System.err.println("BOT: Error de missatges");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ChatRobot cr = new ChatRobot(ChatConfiguration.parse(args));
        cr.doConnect();
    }
}