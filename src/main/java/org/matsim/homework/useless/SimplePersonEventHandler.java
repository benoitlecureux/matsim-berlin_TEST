package org.matsim.homework.useless;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.core.scoring.PersonExperiencedActivity;

import java.util.HashSet;
import java.util.Set;

public class SimplePersonEventHandler /*implements PersonExperiencedActivity, PersonDepartureEventHandler, ActivityEndEventHandler*/ {/*

    int[] persons = { 388773801,  42211101,  401041301,  394083201,  180886401,  198506201,  267742101,  16903201,  144010301,  44211401,  262885801,  242554201,  386358101,  178865001,  341830701,  141695401,  267001801,  260080001,  172874201,  289522801,  36232201,  383079201,  414667001,  423664601,  318531901,  385676601,  400647701,  189479001,  195858001,  254616401,  394780101,  344206901,  82536801,  339279901,  234334201,  441148801,  206601801,  332164601,  268742701,  250598401,  185717501,  397302601,  203744201,  277370901,  345871901,  313227701,  347438901,  308231101,  315678701,  336837601,  45071301,  82259201,  451610001,  311036401,  360035101,  425600801,  406039601,  482220001,  264213901,  28455001,  88306101,  235551201,  300364301,  409537101,  364913601,  35781101,  335651801,  351679401,  262004401,  369865201,  183310501,  330032701,  235290201,  175846101,  169415901,  218508801,  397851701,  177792601,  224184101,  182384101,  286523701,  415261701,  400629901,  370560601,  246899401,  285693801,  359747801,  344145001,  302451801,  341901001,  475665201,  259016501,  170756501,  435882101,  310709201,  183222901,  336551401,  197199401,  83448001,  450466701,  400693101,  276269301,  267539201,  396890001,  222036401,  171991801,  187221301,  216167501,  359134501,  393150201,  348709401,  209971801,  287039801,  206065901,  178939201,  4576801,  359424201,  296804801,  125738901,  284821801,  438809801,  445177901,  281117301,  456208401,  262601101,  256437401,  410124001,  155604901,  408130801,  288256501,  482284501,  99762101,  183650101,  330449701,  423964801,  181475301,  415370701,  144977901,  309982201,  355023601,  14339201,  185212801,  189160601,  123068201,  437460901,  245846201,  249563001};

    //String inputFile = "C:/Users/Admin/Documents/Benoit/ENTPE/2A/JAVA/MATSim/Via-20.1.1/DATAS/agents.txt";
    //File file=new File("C:/Users/Admin/Documents/Benoit/ENTPE/2A/JAVA/MATSim/Via-20.1.1/DATAS/agents.txt");
    //File file=new File("C:/Users/Admin/Desktop/NewVehicleIDonTheSecoundRun.txt");
    Scanner sc = new Scanner(file);
    sc.useDelimiter("\\Z");
    while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
    }

    Set<String> testeur = new HashSet<>();

    PersonExperiencedActivity personExperiencedActivity = new PersonExperiencedActivity;

    public PersonExperiencedActivity getPersonExperiencedActivity() {
        personExperiencedActivity.getActivity().getCoord()
        return personExperiencedActivity;
    }

    @Override
    public void handleEvent(ActivityEndEvent activityEndEvent) {
        for(int i =0; i<persons.length-1;i++) {
            if (activityEndEvent.getPersonId().equals(Id.createPersonId(String.valueOf(persons[i])))) {
                if (activityEndEvent.getActType().contains("home")) {
                    activityEndEvent.getAttributes().get(x);
                }
            }
        }
    }

    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {

        for(int i =0; i<persons.length-1;i++){
            if(personDepartureEvent.getPersonId().equals(Id.createPersonId(String.valueOf(persons[i])))){
                System.out.println(personDepartureEvent.toString());
                System.out.println(persons.length);
                System.out.println(persons[i]);
            }
        }
    }

    public Set<String> getTesteur(){
        return 0;
    }

    public void printTesteur(){
        System.out.println(getTesteur());
    }
}

package org.matsim.homework;

        import org.matsim.api.core.v01.Id;
        import org.matsim.api.core.v01.events.*;

        import org.matsim.api.core.v01.events.handler.*;
        import org.matsim.api.core.v01.population.Person;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;
        import org.xml.sax.SAXException;

        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.ParserConfigurationException;
        import java.io.*;
        import java.util.*;


public class SimpleEventHandler implements LinkEnterEventHandler{

    int[] links = {150439, 36874,
            77388, 81239,
            77387, 81240,
            77386 ,153659,
            77382 ,153660,
            77391, 78198,
            13016, 133604,
            13015, 133605,
            13014, 133606,
            99280, 49245,
            78199, 99226,
            99312, 99257 ,144206, 144221,
            48013, 144197 ,99236, 99266,
            111755, 144198 ,144196, 48015,
            111754,
            144199, 144198, 144196, 48016,
            144193, 77323, 144178, 144190,
            144192,
            72173, 77389,
            77390,
            144179, 102671,
            62494, 77379,
            91121, 62499,
            152708, 152713,
            62634, 62495, 98340, 143455,
            62633, 98343, 62509, 143455,
            62632, 98343, 62509, 143456,
            98316, 62502,
            46610, 149298,
            46609, 147020,
            147142, 147052,
            28917, 28916,
            157336, 8008,
            157335, 8009,
            157334, 8010,
            151527, 15733,
            8007, 835
    };


    // To print vehicles in file //

    public final BufferedWriter bufferedWriter;

    public SimpleEventHandler(String outputFile) throws IOException {
        FileWriter fileWriter = new FileWriter(outputFile);
        bufferedWriter = new BufferedWriter(fileWriter);
    }


    Set<String> affectedVehicles = new HashSet<>();
    public Map<String, Double> linkDistance = new HashMap<>();  // LinkId, LinkLength


    // Fill affectedVehicles with File of vehiclesBundesallee.txt

    public SimpleEventHandler() throws IOException, ParserConfigurationException, SAXException {
        //File file = new File("scenarios/berlin-v5.2-1pct/output/vehiclesBundesallee.txt");
        File file = new File("scenarios/berlin-v5.2-1pct/output/vehiclesBundesallee150.txt");

        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            affectedVehicles.add(in.nextLine());
        }

        // Pass all links with length to Map linkDistance READING XML

        File fileNetwork = new File("scenarios/berlin-v5.2-1pct/input/berlin-v5-network.xml/be_5_network_with-pt-ride-freight.xml");
        Scanner in2 = new Scanner(fileNetwork);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(fileNetwork);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("link");

        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Double distance = Double.parseDouble( eElement.getAttribute("length") );
                linkDistance.put(eElement.getAttribute("id"), distance);
            }
        }
    }


    @Override
    public void handleEvent(LinkEnterEvent event) {

        for(int i=0; i<links.length-1; i++) {
            String linkToString = String.valueOf(links[i]);     // Int to String
            if (event.getLinkId().equals(Id.createLinkId(linkToString))) {
                affectedVehicles.add(event.getVehicleId().toString());   // no repeats
            }
        }
    }

    public Map<Id<Person>, Double> departureMap = new HashMap<>();
    public double totalTime = 0;

    @Override
    public void handleEvent(PersonDepartureEvent event) {
        if(affectedVehicles.contains(event.getPersonId().toString())) {     // Vehicle IDs = Person IDs
            departureMap.put(event.getPersonId(), event.getTime());
        }
    }

    @Override
    public void handleEvent(PersonArrivalEvent event) {
        if(departureMap.containsKey(event.getPersonId())) {
            totalTime += event.getTime() - departureMap.get(event.getPersonId());
        }
    }




    public void print() throws IOException {
        System.out.println("Affected Vehicles = " + affectedVehicles.size());


        // All Affected Vehicles to "vehiclesBundesallee.txt" //
        /*
        Iterator<String> it = affectedVehicles.iterator();
        while(it.hasNext()){
            bufferedWriter.write(it.next());
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();


        // Print affectedVehicles //
        /*
        Iterator<String> it = affectedVehicles.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }



        System.out.println("Number of Agents in Map = " + departureMap.keySet().size());
        System.out.println("Total Hours = " + totalTime/3600);  // Comes in seconds

    /////////////////////////////////////////////////////////////////////////////////
    // AFFECTED Agents TIME IN TRAFFIC:
    // ORIGINAL --> 1115.65 hours, 527 agents  (2 agents missing, not cars)
    // 150IT --> 1203.70 hours, 549 agents  (3 agents missing, not cars)
    /////////////////////////////////////////////////////////////////////////////////
}



             double totalDistance = 0;

@Override
public void handleEvent(LinkEnterEvent event) {
        if(affectedVehicles.contains(event.getVehicleId().toString())){
        totalDistance+=linkDistance.get(event.getLinkId().toString());
        }
        }


public void print() throws IOException {

        System.out.println("Size = " + linkDistance.keySet().size());   // 202360

        System.out.println("Distance in km = " + totalDistance/1000);     // Metros a Kms

        System.out.println("Vehicles = " + affectedVehicles.size());

        /////////////////////////////////////////////////////////////////////////////////
        // AFFECTED Agents DISTANCE IN TRAFFIC:
        // ORIGINAL --> 23368.05 kms for 529 vehicles
        // 150IT --> 24017.29 kms for 552 vehicles
        /////////////////////////////////////////////////////////////////////////////////

        }
*/
        }