package hotelManagement.process.service.room;

import hotelManagement.process.model.Room;
import hotelManagement.process.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements IRoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void remove(Long id) {
        roomRepository.deleteById(id);
    }
}
