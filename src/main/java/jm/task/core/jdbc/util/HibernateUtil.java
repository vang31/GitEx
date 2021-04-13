package configHibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Создаем регисстрационный builder
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                //Прописываем настройки Hibernate, like xml properties
                Map<String, String> settings = new HashMap<>();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/task1");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "postgres");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

                //StandardServiceRegistryBuilder - используется для загрузки деталей
                registryBuilder.applySettings(settings);

                //Создаем регистратор, подвязываем на стандартномСервисеРегистреКонструкторе
                registry = registryBuilder.build();

                //Create MetadataSources - what is it??
                MetadataSources sources = new MetadataSources(registry);

                //Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                //Create SessionFactory - ???
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if(registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

