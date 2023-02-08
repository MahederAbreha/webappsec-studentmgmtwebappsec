package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassRoomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Override
    public ClassRoom addNewClassRoom(ClassRoom newClassRoom) {
        return classRoomRepository.save(newClassRoom);
    }
}
