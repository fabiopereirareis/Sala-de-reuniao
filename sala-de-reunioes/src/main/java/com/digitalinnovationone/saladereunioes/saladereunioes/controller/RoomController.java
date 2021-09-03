package com.digitalinnovationone.saladereunioes.saladereunioes.controller;

import com.digitalinnovationone.saladereunioes.saladereunioes.exception.ResourseNotFoundException;
import com.digitalinnovationone.saladereunioes.saladereunioes.model.Room;
import com.digitalinnovationone.saladereunioes.saladereunioes.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // porta padrão angular
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/id")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId) throws ResourseNotFoundException{
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(()-> new ResourseNotFoundException("Rooms not found :: " + roomId));
            return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> upDateRoms(@PathVariable(value = "id") Long roomId,
                                            @Valid @RequestBody Room roomDetails) throws ResourseNotFoundException{
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourseNotFoundException("Rooms not found :: " + roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStarthour(roomDetails.getStarthour());
        room.setEndthour(roomDetails.getEndthour());
        final Room updateRoom =roomRepository.save(room);
        return ResponseEntity.ok().body(updateRoom);
    }

    public Map<String, Boolean> deleteRoom(@PathVariable(value = "i")Long roomId) throws ResourseNotFoundException{
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourseNotFoundException("Rooms not found :: " + roomId));
        roomRepository.delete(room);
        Map<String,Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse ;
    }
}
