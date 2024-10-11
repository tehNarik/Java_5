import java.util.ArrayList;
import java.util.List;

// Клас Car - узагальнений клас для легкових автомобілів
abstract class Car {
    private String model;
    private double price;
    private double fuelConsumption; // Витрати палива (л/100 км)
    private int maxSpeed;

    public Car(String model, double price, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    // Абстрактний метод для опису автомобіля
    public abstract void describe();
}

// Клас Sedan - легковий автомобіль
class Sedan extends Car {
    public Sedan(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }

    @Override
    public void describe() {
        System.out.println("Sedan: " + getModel() + ", Max speed: " + getMaxSpeed() + " km/h");
    }
}

// Клас SUV - позашляховик
class SUV extends Car {
    public SUV(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }

    @Override
    public void describe() {
        System.out.println("SUV: " + getModel() + ", Max speed: " + getMaxSpeed() + " km/h");
    }
}

// Клас Hatchback - хетчбек
class Hatchback extends Car {
    public Hatchback(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }

    @Override
    public void describe() {
        System.out.println("Hatchback: " + getModel() + ", Max speed: " + getMaxSpeed() + " km/h");
    }
}

// Клас TaxiFleet - таксопарк

class TaxiFleet {
    private List<Car> cars;

    public TaxiFleet() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Car car : cars) {
            totalValue += car.getPrice();
        }
        return totalValue;
    }

    public void sortCarsByFuelConsumption() {
        cars.sort((Car c1, Car c2) -> Double.compare(c1.getFuelConsumption(), c2.getFuelConsumption()));
    }

    // Повертаємо список автомобілів, які потрапляють у діапазон швидкості
    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> carsInRange = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                carsInRange.add(car);
            }
        }
        return carsInRange;
    }

    public void printFleet() {
        for (Car car : cars) {
            car.describe();
        }
    }
}

// Основний клас для тестування
public class Main {
    public static void main(String[] args) {
        // Створення таксопарку
        TaxiFleet fleet = new TaxiFleet();

        // Додавання автомобілів у парк
        fleet.addCar(new Sedan("Toyota Camry", 30000, 8.5, 210));
        fleet.addCar(new SUV("Nissan X-Trail", 35000, 10.2, 180));
        fleet.addCar(new Hatchback("Volkswagen Golf", 25000, 6.8, 220));
        fleet.addCar(new Sedan("Opel Vectra", 27000, 7, 190));

        // Виведення інформації про парк
        System.out.println("Taxi fleet:");
        fleet.printFleet();

        // Обчислення загальної вартості парку
        System.out.println("Total value of fleet: $" + fleet.calculateTotalValue());

        // Сортування за витратами палива
        fleet.sortCarsByFuelConsumption();
        System.out.println("\nSorted by fuel consumption:");
        fleet.printFleet();

        // Пошук автомобілів за діапазоном швидкості
        List<Car> carsInRange = fleet.findCarsBySpeedRange(200, 220);
        if (!carsInRange.isEmpty()) {
            System.out.println("\nCars found in speed range:");
            for (Car car : carsInRange) {
                car.describe();
            }
        } else {
            System.out.println("\nNo car found in the specified speed range.");
        }
    }
}
