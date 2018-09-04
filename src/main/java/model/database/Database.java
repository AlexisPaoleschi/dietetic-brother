package model.database;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Database {

    /** The session. */
    private final Session session;

    private SessionFactory sessionFactory;

    /**
     * Constructeur de la base de données récupérant une SessionFactory d'Hibernate.
     *
     * @param launchMode : mode de lancement de Javatrack
     */
    public Database() {
        session = getSessionFactory().openSession();

        session.createSQLQuery("SELECT * from glucides").list();
        System.out.println();

        // // try {
        // // executeSQLQuery("INSERT INTO \"glucides\" (\"aliment / produit\") VALUES ('987987')");
        // String str = "INSERT INTO `glucides` (`FAMILLE D’ALIMENTS`, `sous famille alimentaire`, `sous
        // famille alimentaire 2`, "
        // + "`code produit`, `aliment / produit`, `Glucides`) VALUES ('viandes, j, poissons', 'viandes
        // cuites', "
        // + "'buf et ', 6310, 'Boeuf, queue, bouillie/cuite à" + new Date().getTime() + "', 'traces')";
        //
        // str.contains("`");
        //
        // // executeSQLQuery(new String(str.replaceAll("\n", "").replaceAll("`", "\"").replaceAll(":",
        // // "-").getBytes(), "UTF-8"));
        // // } catch (SQLException | UnsupportedEncodingException e) {
        // // TODO Auto-generated catch block
        // // e.printStackTrace();
        // // }
        //
        // StringBuilder result = new StringBuilder("");
        //
        // ClassLoader classLoader = getClass().getClassLoader();
        // File file = new File(classLoader.getResource("sql/model_dietetic_insert.sql").getFile());
        //
        // try (Scanner scanner = new Scanner(file)) {
        // while (scanner.hasNextLine()) {
        // String line = scanner.nextLine();
        // result.append(line).append("\n");
        // }
        // scanner.close();
        //
        // String query = result.toString().replaceAll("\n", "").replaceAll("`", "\"").replaceAll(":",
        // "-").replaceAll("\\(", "")
        // .replaceAll("\\)", "").replaceAll("œ", "oe");
        //
        // query.contains("\\(");
        //
        // executeSQLQuery(query);
        // } catch (IOException | SQLException e) {
        // e.printStackTrace();
        // }
    }

    /**
     * Méthode permettant de récupérer une SessionFactory d'Hibernate.
     *
     * @return SessionFactory d'Hibernate
     */
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    /**
     * Méthode de fermeture de la base de données.
     */
    public void closeDB() {
        session.clear();
        session.close();
    }

    /**
     * Méthode d'exécution d'une requête SQL par Hibernate.
     *
     * @param requete : la requête SQL
     * @throws SQLException : exception SQL si la requête est erronée
     */
    public void executeSQLQuery(String requete) throws SQLException {
        session.createSQLQuery(requete).executeUpdate();
    }

    // public void createAvailableFood(Food food) {
    // Transaction transaction = null;
    // try {
    // transaction = session.beginTransaction();
    // session.save(food);
    // transaction.commit();
    // } catch (HibernateException e) {
    // transaction.rollback();
    // }
    // }

    //
    // /**
    // * Méthode de modification de balise en base de données.
    // *
    // * @param beacon : l'objet de la balise
    // * @param previousDecimalTid : TID décimal précédent de la balise modifiée
    // * @param previousHexadecimalTid : TID hexadécimal précédent de la balise modifiée
    // * @param previousImei : IMEI précédent de la balise modifiée
    // * @param previousTarget : cible précédente de la balise modifiée
    // * @param beaconsList : la liste des balises déclarées
    // * @return Boolean si la balise a été modifiée avec succès ou non
    // * @throws DatabaseException the database exception
    // */
    // public boolean updateBeacon(Beacon beacon,
    // String previousDecimalTid,
    // String previousHexadecimalTid,
    // String previousImei,
    // String previousTarget,
    // List<Beacon> beaconsList)
    // throws DatabaseException {
    // Transaction transaction = null;
    // try {
    // transaction = session.beginTransaction();
    // session.update(beacon);
    // transaction.commit();
    // DatabaseAlert.modifyBeaconAlert(beacon);
    // return true;
    // } catch (final HibernateException e) {
    // transaction.rollback();
    // throw new DatabaseException(e.getMessage());
    // }
    // }
    //
    // /**
    // * Méthode de suppression de balise en base de données.
    // *
    // * @param beacon : l'objet de la balise
    // * @return Boolean si la balise a été supprimée avec succès ou non
    // * @throws DatabaseException the database exception
    // */
    // public boolean deleteBeacon(Beacon beacon) throws DatabaseException {
    // Transaction transaction = null;
    // try {
    // transaction = session.beginTransaction();
    // session.delete(beacon);
    // transaction.commit();
    // DatabaseAlert.deleteBeaconAlert(beacon);
    // return true;
    // } catch (final HibernateException e) {
    // transaction.rollback();
    // throw new DatabaseException(e.getMessage());
    // }
    // }
    //
    // /**
    // * Méthode de consultation de toutes les balises déclarées.
    // *
    // * @return Liste de toutes les balises déclarées
    // * @throws DatabaseException the database exception
    // */
    // public List<Beacon> selectAllBeacons() throws DatabaseException {
    // Transaction transaction = null;
    // try {
    // transaction = session.beginTransaction();
    // @SuppressWarnings("unchecked")
    // final List<Beacon> beaconsList = session.createQuery("from " +
    // DatabaseConstant.BEACON_TABLE_NAME).list();
    // transaction.commit();
    // return beaconsList;
    // } catch (final HibernateException e) {
    // transaction.rollback();
    // throw new DatabaseException(e.getMessage());
    // }
    // }
    //
    // /**
    // * Méthode de consultation de balise ayant pour TID décimal decimalTID.
    // *
    // * @param decimalTID : TID de la balise
    // * @return Liste de toutes les balises déclarées ayant pour TID décimal decimalTID
    // * @throws DatabaseException the database exception
    // */
    // public List<Beacon> selectBeaconsWhereDecimalTID(String decimalTID) throws DatabaseException {
    // Transaction transaction = null;
    // try {
    // transaction = session.beginTransaction();
    // final Query createQuery = session.createQuery("from " + DatabaseConstant.BEACON_TABLE_NAME + " where "
    // + DatabaseConstant.BEACON_COLUMN_NAME_DECIMAL_TID + " = :decimalTID");
    // createQuery.setParameter("decimalTID", decimalTID);
    // @SuppressWarnings("unchecked")
    // final List<Beacon> beaconsList = createQuery.list();
    // transaction.commit();
    // return beaconsList;
    // } catch (final HibernateException e) {
    // transaction.rollback();
    // throw new DatabaseException(e.getMessage());
    // }
    // }
}
