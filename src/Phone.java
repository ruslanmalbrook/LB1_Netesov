import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Phone {
    String name;
    String producer;
    int memory;
    double width;

    public Phone (String name, String producer, int memory, double width) {
        this.name=name;
        this.producer=producer;
        this.memory=memory;
        this.width=width;
    }

    public static void main(String[] args) {
        Phone phones[] = new Phone[14];

        phones[0] = new Phone("iPhone 4s", "Apple", 4, 4.5);
        phones[1] = new Phone("A50", "Samsung", 64, 12.4);
        phones[2] = new Phone("Galaxy S10", "Samsung", 128, 10.5);
        phones[3] = new Phone("iPhone XS", "Apple", 64, 6.7);
        phones[4] = new Phone("MatePro", "Xiaomi", 128, 12.5);
        phones[5] = new Phone("Z Ultra", "XPeria", 32, 9.5);
        phones[6] = new Phone("Ericsson M", "Sony", 2, 2.5);
        phones[7] = new Phone("Redmi D5", "Xiaomi", 128, 5.3);
        phones[8] = new Phone("3310", "Nokia", 1, 1.5);
        phones[9] = new Phone("iPhone 8", "Apple", 64, 6.5);
        phones[10] = new Phone("Nano Pro", "Xiaomi", 128, 3.5);
        phones[11] = new Phone("Galaxy Z Fold", "Samsung", 256, 6.8);
        phones[12] = new Phone("T8", "BlackBerry", 32, 5.5);
        phones[13] = new Phone("5s", "Apple", 16, 4.5);

        System.out.println("отсортируем по значению памяти");

        //отсортируем по значению памяти

        for (int i = 0; i < phones.length; i++) {
            int j_max = i;

            for (int j = i + 1; j < phones.length; j++) {
                if (phones[j_max].memory < phones[j].memory) {
                    j_max = j;
                }
            }

            //swap
            Phone temp = phones[i];
            phones[i] = phones[j_max];
            phones[j_max] = temp;
        }

        //print
        for (Phone phone : phones) phone.print();

        System.out.println("отсортируем по значению ширины экрана");

        //отсортируем по значению ширины экрана

        for (int i = 0; i < phones.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < phones.length; j++) {
                if (phones[j_max].width < phones[j].width) {
                    j_max = j;
                }
            }

            Phone temp = phones[i];
            phones[i] = phones[j_max];
            phones[j_max] = temp;
        }

        //print
        for (Phone phone : phones) phone.print();

        System.out.println("отсортируем по имени изготовителя");

        //отсортируем по имени изготовителя

        for (int i = 0; i < phones.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < phones.length; j++) {
                if (phones[j_max].producer.compareTo(phones[j].producer) < 0) {
                    j_max = j;
                }
            }

            Phone temp = phones[i];
            phones[i] = phones[j_max];
            phones[j_max] = temp;
        }

        //print
        for (Phone phone : phones) phone.print();

        System.out.println("отсортируем по названию модели");

        //отсортируем по названию модели

        for (int i = 0; i < phones.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < phones.length; j++) {
                if (phones[j_max].name.compareTo(phones[j].name) < 0) {
                    j_max = j;
                }
            }

            Phone temp = phones[i];
            phones[i] = phones[j_max];
            phones[j_max] = temp;
        }

        //print
        for (Phone phone : phones) phone.print();

        try {
            PrintStream out = new PrintStream(new File("D:/phones.txt"));

            //save to file
            for (Phone phone : phones) phone.printToFile(out);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void print() {
        System.out.printf("%15s %15s %3d %.1f\n",name, producer, memory, width);
    }

    void printToFile(PrintStream stream) {
        stream.printf("%15s %15s %3d %.1f\n",name, producer, memory, width);
    }
}