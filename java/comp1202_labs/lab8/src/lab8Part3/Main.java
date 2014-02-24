package lab8Part3;

public class Main {

	public static void main(String[] args) {
		Bicycle b1 = new Bicycle("B001", 12);
		System.out.println(b1.getName() + " has " + b1.getNumberOfWheels() + " wheels, it has a maximum limit of " + b1.getMaxSpeed() + " miles per hour, and it makes the noise of "  );
		b1.makeNoise();
		
		Car c1 = new Car("C001", 180);
		System.out.println(c1.getName() +  "  has a maximum limit of " + c1.getMaxSpeed() + " miles per hour, and it makes the noise of "  );
		c1.makeNoise();
		c1.fueltype();
		
		JetPlane p1 = new JetPlane("P777", 200);
		System.out.println(p1.getName() + " can take a maximum of " + p1.getNumberOfPassenger() + " passengers"  );	
		p1.fueltype();
	}

}

/**
 *  note for system structure:
 *  
 *  Transport (abstract class, extended by:)
 *		Road Vehicle
 *			Car
 *			Train
 *			Cycle
 *				Bicycle
 *				Tricycle
 *		JetPlane
 *
 *	Refuelable (interface class, implemented by:)
 *		Car
 *		JetPlane
 *
 */