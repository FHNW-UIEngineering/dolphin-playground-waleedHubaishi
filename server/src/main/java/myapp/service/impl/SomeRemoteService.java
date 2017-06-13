package myapp.service.impl;

import java.util.List;
import java.util.Random;

import myapp.presentationmodel.person.MountainAtt;
import org.opendolphin.core.server.DTO;

import myapp.service.SomeService;
import myapp.util.DTOMixin;

public class SomeRemoteService implements SomeService, DTOMixin {
    String[] names = {"Neil Amstrong"  , "Michael Collins" , "Edwin Aldrin",      // Apollo 11
                      "Charles Conrad" , "Richard Gordon"  , "Alan Bean",         // Apollo 12
                      "James Lovell"   , "John Swigert"    , "Fred Haise",        // Apollo 13
                      "Alan Shepard"   , "Stuart Roosa"    , "Edgar Mitchell",    // Apollo 14
                      "David Scott"    , "Alfred Worden"   , "James Irwin",       // Apollo 15
                      "John Young"     , "Thomas Mattingly", "Charles Duke",      // Apollo 16
                      "Eugene Cernan"  , "Ronald Evans"    , "Harrison Schmitt"}; // Apollo 17

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

    @Override
    public void save(List<DTO> dtos) {
        System.out.println(" Data to be saved");
        dtos.stream()
            .flatMap(dto -> dto.getSlots().stream())
            .map(slot -> String.join(", ", slot.getPropertyName(), slot.getValue().toString(), slot.getQualifier()))
            .forEach(System.out::println);
    }
}
