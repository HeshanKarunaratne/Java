package designpatterns.bridge;

/**
 * @author Heshan Karunaratne
 */
abstract class TV {
    Remote remote;

    public TV(Remote remote) {
        this.remote = remote;
    }

    abstract void on();

    abstract void off();
}

interface Remote {
    public void on();

    public void off();
}

class Sony extends TV {
    Remote remoteType;

    public Sony(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Sony TV on");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Sony TV off");
        remoteType.off();
    }
}

class Philips extends TV {
    Remote remoteType;

    public Philips(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Philips TV on");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Philips TV off");
        remoteType.off();
    }
}

class OldRemote implements Remote {

    @Override
    public void on() {
        System.out.println("On with old remote");
    }

    @Override
    public void off() {
        System.out.println("Off with old remote");
    }
}

class NewRemote implements Remote {

    @Override
    public void on() {
        System.out.println("On with new remote");
    }

    @Override
    public void off() {
        System.out.println("Off with new remote");
    }
}

class BridgeTest {
    public static void main(String[] args) {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
        System.out.println();
    }
}