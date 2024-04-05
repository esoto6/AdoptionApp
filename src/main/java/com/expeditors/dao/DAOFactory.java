package com.expeditors.dao;

import com.expeditors.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DAOFactory {

    /*
    @Value("${app.profile}")
    private String appENV;

    public PersonDAO getPersonDAO(){
        System.out.println(STR."Here: \{appENV}");
        return switch(appENV){
            case "dev" -> new InMemoryDAO();
            case "prod" -> new JPA_DAO();
            default -> throw new IllegalArgumentException(STR."Profile: \{appENV} is invalid!");
        };
    }

     */
    /*
/////////////////////// Attempt to used autowire
    @Autowired
    @Qualifier("InMemoryDAO")
    private PersonDAO InMemoryDAO;

    @Autowired
    @Qualifier("JPA_DAO")
    private PersonDAO JPA_DAO;


    @Profile("dev")
    @Component("devDAOFactory")
    public static class DevDAOFactor extends PersonDAOFactory{
        public PersonDAO getDAO(){
            return InMemoryDAO;
        }
    }
    /////////////////////////////////////////////////
 */

    private static Map<String, Object> objects = new ConcurrentHashMap<>();
    private static ResourceBundle bundle = ResourceBundle.getBundle("backend");
    private static String profile;


    static {
        profile = bundle.getString("backend.profile");
    }

    public static void clear() { objects.clear();}

    public static int getObjectCount() { return objects.size();}

    public static PersonDAO getPersonDAO(){
        return switch (profile) {
            case "dev" -> (PersonDAO)objects.computeIfAbsent("adopterDAO", k -> new InMemoryDAO());
            case "prod" -> (PersonDAO)objects.computeIfAbsent ("adopterDAO", k -> new JPA_DAO());
            default -> throw new IllegalArgumentException(STR."Invalid DAO type: \{profile}");
        };
    }

    public static PersonService personService(){
        PersonService service =
                (PersonService) objects.computeIfAbsent("personService",
                    k -> {
                        PersonService as = new PersonService();
                        PersonDAO dao = getPersonDAO();
                        as.setPersonDAO(dao);
                        return as;
                    });
        return service;
    }
}
