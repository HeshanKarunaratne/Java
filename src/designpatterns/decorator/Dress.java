package designpatterns.decorator;

/**
 * @author Heshan Karunaratne
 */
interface Dress {
    public void assemble();
}

class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic Dress features");
    }
}

class DressDecorator implements Dress {

    protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

class CasualDress extends DressDecorator {

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress features");
    }
}

class SportyDress extends DressDecorator {

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress features");
    }
}

class FancyDress extends DressDecorator {

    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress features");
    }
}

class DecoratorPatternTest {
    public static void main(String[] args) {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
        System.out.println();

        Dress casualFancySportyDress = new CasualDress(new FancyDress(new SportyDress(new BasicDress())));
        casualFancySportyDress.assemble();
        System.out.println();
    }
}