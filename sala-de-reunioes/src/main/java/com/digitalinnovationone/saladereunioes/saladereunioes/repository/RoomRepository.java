package com.digitalinnovationone.saladereunioes.saladereunioes.repository;

import com.digitalinnovationone.saladereunioes.saladereunioes.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
