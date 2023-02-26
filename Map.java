import java.util.ArrayList;
import java.util.List;


/**
 * Map
 */
public class Map {

    List<Location> locations = new ArrayList<>(); 

    void map() {
         // Create locations and add them to the locations arraylist
         locations.add(new Location("START", 0));
         locations.add(new LocationCity("ABAY QUNANBAY", 1,
                 60, 10, null));
 
         locations.add(new LuckyCard("CHANCE",2));
 
         locations.add(new LocationCity("MAGZHAN ZHUMABAY", 3,
                 60, 10, null));
 
         locations.add(new TaxAdmin("INCOME TAX", 4, 200)); // TAX ADMINISTRATION LOCATION
 
         locations.add(new LocationCity("SHAKARIM QUDAIBERDI", 5,
                 200, 40, null));
 
         locations.add(new LocationCity("ALIKHAN BOKEYKHANOV", 6,
                 100, 20, null));
 
         locations.add(new LuckyCard("CHANCE",7));
 
         locations.add(new LocationCity("SAKEN SEIFULLIN", 8,
                 100, 20, null));
         locations.add(new LocationCity("TURAR RYSKULOV", 9,
                 120, 25, null));
         locations.add(new Jail("JAIL", 10, 0));// JAIL LOCATION
 
         locations.add(new LocationCity("BEIMBET MAILIN", 11,
                 140, 30, null));
         locations.add(new TaxAdmin("TAX ADMIN", 12, 150)); // TAX ADMINISTRATION LOCATION
 
         locations.add(new LocationCity("ALIBI ZHANGELDIN", 13,
                 140, 30, null));
         locations.add(new LocationCity("AKHMET BAITURSUNULY", 14,
                 160, 35, null));
         locations.add(new LocationCity("DINMUKHAMMED QONAYEV", 15,
                 200, 40, null));
         locations.add(new LocationCity("MUSTAFA SHOQAI", 16,
                 180, 35, null));
         locations.add(new LuckyCard("CHANCE",17));
 
         locations.add(new LocationCity("NURSULTAN NAZARBAYEV", 18,
                 180, 35, null));
         locations.add(new LocationCity("SHOQAN UALIKHANOV", 19,
                 200, 40, null));
         locations.add(new TaxAdmin("FREE PARKING", 20, 0)); // BURADA HICBISEY OLMAMASI DOGRU
 
         locations.add(new LocationCity("MIRZHAQYP DULATULY", 21,
                 220, 45, null));
         locations.add(new LuckyCard("CHANCE",22));
 
         locations.add(new LocationCity("SMAGUL SADUAQAS", 23,
                 220, 45, null));
         locations.add(new LocationCity("ZHAKHANSHA DOSMUKHAMMED", 24,
                 240, 50, null));
         locations.add(new LocationCity("ZHAQYP AQBAI", 25,
                 200, 40, null));
         locations.add(new LocationCity("TURAR RYSQULOV", 26,
                 260, 55, null));
         locations.add(new LocationCity("BAQYTZHAN QARATAYEV", 27,
                 260, 55, null));
         locations.add(new TaxAdmin("TAX ADMIN", 28, 150));
         locations.add(new LocationCity("MUKHAMMEDZHAN TYNYSHBAI", 29,
                 280, 60, null));
 
 
         locations.add(new Jail("GO TO JAIL", 30, 1));
 
 
         locations.add(new LocationCity("MUKHTAR AUEZOV", 31,
                 300, 65, null));
         locations.add(new LocationCity("ZHUSIVBEK AIMAUYTOV", 32,
                 300, 65, null));
 
         locations.add(new LuckyCard("CHANCE",33));
 
         locations.add(new LocationCity("BAUYRZHAN MOMYSHULY", 34,
                 320, 70, null));
 
         locations.add(new LocationCity("AMRE QASHAUBAI", 35,
                 200, 40, null));
 
         locations.add(new LuckyCard("CHANCE",36));
 
         locations.add(new LocationCity("ALIYA MOLDAGULOVA", 37,
                 350, 75, null));
         locations.add(new TaxAdmin("SUPER TAX", 38, 100));
         locations.add(new LocationCity("MANSHUK MAMETOVA", 39,
                 400, 80, null));
    }

}