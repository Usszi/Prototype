package hr.java.production.main;

import hr.java.production.enumeration.Enumeration;
import hr.java.production.exception.sameArticleException;
import hr.java.production.exception.sameCategoryException;
import hr.java.production.model.*;
import hr.java.production.sort.ProductionSorter;
import hr.java.production.sort.VolumenSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * Sluzi za pokretanje programa.
     */

    public static void main(String[] args) {
        log.info("Pokrenuli ste program");

        List<Item> items = new ArrayList<>();
        List<Factory> factories = new ArrayList<>();
        List<Store> stores = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();

        readCategories(categories);
        readItems(items, categories);
        readAddresses(addresses);
        readFactories(factories, items, addresses);
        writeFactories(factories);
        readStores(stores, items);

        log.info("Zavrsio rad programa");
    }

    private static void writeFactories(List<Factory> factories) {
        try (FileOutputStream fileFactories = new FileOutputStream("dat/upisTvornica.dat");
             ObjectOutputStream unosFactories = new ObjectOutputStream(fileFactories)) {
             unosFactories.writeObject(factories);
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ne postoji");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readCategories(List<Category> categories) {
        File fileCategories = new File("dat/categories.txt");
        if (fileCategories.exists()) {

            try (FileReader fileReader = new FileReader(fileCategories);
                 BufferedReader lineReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Long id = Long.parseLong(line);
                    String name = lineReader.readLine();
                    String description = lineReader.readLine();
                    Category newCategory = new Category(id, name, description);
                    categories.add(newCategory);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Datoteka ne postoji");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            categories.stream().forEach(System.out::println);

        }
    }

    private static void readItems(List<Item> items, List<Category> categories) {
        File fileItems = new File("dat/items.txt");
        if (fileItems.exists()) {

            try (FileReader fileReader = new FileReader(fileItems);
                 BufferedReader lineReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Long id = Long.parseLong(line);
                    BigDecimal discountId = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    String name = lineReader.readLine();
                    Long categoryId = Long.parseLong(lineReader.readLine());
                    Category kategorija = categories.stream().filter(i -> i.getId().equals(categoryId))
                            .findFirst().get();
                    BigDecimal width = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    BigDecimal highth = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    BigDecimal lenght = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    BigDecimal productionCost = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    BigDecimal sellingPrice = BigDecimal.valueOf(Double.parseDouble(lineReader.readLine()));
                    Discount popust = new Discount(discountId);

                    Item newItem = new Item(id, popust, name, kategorija, width, highth, lenght, productionCost, sellingPrice);
                    items.add(newItem);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Datoteka ne postoji");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            items.stream().forEach(System.out::println);
        }
    }

    private static void readFactories(List<Factory> factories, List<Item> items, List<Address> addresses) {
        File fileFactoreis = new File("dat/factories.txt");
        if (fileFactoreis.exists()) {

            try (FileReader fileReader = new FileReader(fileFactoreis);
                 BufferedReader lineReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Long id = Long.parseLong(line);
                    String name = lineReader.readLine();
                    String ulica = lineReader.readLine();
                    Address adresa = addresses.stream().filter(i -> i.getStreet().equals(ulica))
                            .findFirst().get();
                    String idArtikla = lineReader.readLine(); // 1,2,3
                    String[] itemIds = idArtikla.split(","); // ["1" , 2, 3]

                    Set<Item> factoryItems = new HashSet<>();
                    for (String s : itemIds) {
                        Item artikli = items.stream().filter(i -> i.getId().equals(Long.parseLong(s)))
                                .findFirst().get();
                        factoryItems.add(artikli);
                    }
                    Factory newFactory = new Factory(id, name, adresa,factoryItems );
                    factories.add(newFactory);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Datoteka ne postoji");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            factories.stream().forEach(System.out::println);
        }
    }

    private static void readAddresses(List<Address> addresses) {
        File fileAdresses = new File("dat/addresses.txt");
        if (fileAdresses.exists()) {

            try (FileReader fileReader = new FileReader(fileAdresses);
                 BufferedReader lineReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    String name = line;
                    String housenumber = lineReader.readLine();
                    String grad = lineReader.readLine();
                    Enumeration enumeracija = null;

                    for (Enumeration enumeration : Enumeration.values()) {
                        if (enumeration.getNazivGrada().equalsIgnoreCase(grad)) {
                            enumeracija = enumeration;
                        }
                    }
                    Address newAddress = new Address(name, housenumber, enumeracija);
                    addresses.add(newAddress);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Datoteka ne postoji");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            addresses.stream().forEach(System.out::println);
        }
    }

    private static void readStores(List<Store> stores,List<Item> items) {
        File fileStores = new File("dat/stores.txt");
        if (fileStores.exists()) {

            try (FileReader fileReader = new FileReader(fileStores);
                 BufferedReader lineReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Long id = Long.parseLong(line);
                    String name = lineReader.readLine();
                    String webAdresa = lineReader.readLine();
                    String idArtikla = lineReader.readLine(); // 1,2,3
                    String[] itemIds = idArtikla.split(","); // ["1" , 2, 3]

                    Set<Item> storeItems = new HashSet<>();
                    for (String s : itemIds) {
                        Item artikli = items.stream().filter(i -> i.getId().equals(Long.parseLong(s)))
                                .findFirst().get();
                        storeItems.add(artikli);
                    }
                    Store newStore = new Store(id,name,webAdresa,storeItems);
                    stores.add(newStore);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Datoteka ne postoji");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stores.stream().forEach(System.out::println);
        }
    }


}
