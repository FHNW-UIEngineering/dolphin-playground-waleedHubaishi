package myapp.service.impl;

import myapp.presentationmodel.person.MountainAtt;
import myapp.service.SomeService;
import myapp.util.DTOMixin;
import org.opendolphin.core.server.DTO;

import java.util.List;
import java.util.Random;

public class SomeRemoteService implements SomeService, DTOMixin {


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
