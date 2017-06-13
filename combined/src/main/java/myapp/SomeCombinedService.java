package myapp;

import myapp.presentationmodel.person.MountainAtt;
import myapp.service.SomeService;
import myapp.util.DTOMixin;
import org.opendolphin.core.server.DTO;

import java.util.List;
import java.util.Random;

public class SomeCombinedService implements SomeService, DTOMixin {

    String[] mountains= {
            "0","Albis, Bürglen","916.0","Hauptgipfel","Mittelland","Albiskette","12.0","Wilerberg","376.0",
            "Sihlbrugg Punkt 540","Albiskette vom Uetliberg"};

    @Override
    public DTO loadSomeEntity() {
        long id = createNewId();
        Random r        = new Random();
        String mountainName     = mountains[r.nextInt(mountains.length)];
        int    height      = r.nextInt(43);
        return new DTO(createSlot(MountainAtt.MOUNTAIN_ID, id     , id),
                createSlot(MountainAtt.MOUNTAIN_NAME, mountainName   , id),
                createSlot(MountainAtt.MOUNTAIN_HEIGHT, height    , id));
    }

   /* String[] names = {"Virgil Grissom", "Edward White", "Roger Chaffee",      // Apollo 1
                      "Walter Schirra", "Donn Eisele" , "Walter Cunningham",  // Apollo 7
                      "Frank Borman"  , "James Lovell", "William Anders",     // Apollo 8
                      "James McDivitt", "David Scott" , "Russel Schweickart", // Apollo 9
                      "Tom Stafford"  , "John Young"  , "Eugene Cernan"};     // Apollo 10*/

   /* @Override
    public DTO loadSomeEntity() {
        long id = createNewId();

        Random r        = new Random();
        String name     = names[r.nextInt(names.length)];
        int    age      = r.nextInt(43);
        boolean isAdult = age >= 18;
        return new DTO(createSlot(MountainAtt.ID      , id     , id),
                       createSlot(PersonAtt.NAME    , name   , id),
                       createSlot(PersonAtt.AGE     , age    , id),
                       createSlot(PersonAtt.IS_ADULT, isAdult, id));
    }*/

    @Override
    public void save(List<DTO> dtos) {
        System.out.println(" Data to be saved");
        dtos.stream()
            .flatMap(dto -> dto.getSlots().stream())
            .map(slot -> String.join(", ", slot.getPropertyName(), slot.getValue().toString(), slot.getQualifier()))
            .forEach(System.out::println);
    }
}
