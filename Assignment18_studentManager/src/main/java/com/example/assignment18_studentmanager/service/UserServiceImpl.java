package com.example.assignment18_studentmanager.service;

import com.example.assignment18_studentmanager.model.dto.ClasszDTO;
import com.example.assignment18_studentmanager.model.dto.UserDTO;
import com.example.assignment18_studentmanager.model.entity.Classz;
import com.example.assignment18_studentmanager.model.entity.Subject;
import com.example.assignment18_studentmanager.model.entity.User;
import com.example.assignment18_studentmanager.repository.ClasszRepository;
import com.example.assignment18_studentmanager.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClasszRepository classzRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public User findClassById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Override
    public String createUser(User user) {
//        if (userRepository.existsByPhone(user.getPhone()))
//            return "Học sinh đã tồn tại. vui lòng thêm học sinh khác";
//        User tmp = new User();
//        tmp.setName(user.getName());
//        tmp.setPhone(user.getPhone());
//        Classz classzDTO = user.getClassz();
//        Classz classz;
//        if (classzRepository.existsById(classzDTO.getId())) {
//            classz = classzRepository.findById(classzDTO.getId()).get();
//        } else {
//            classz = new Classz();
//            classz.setName(classzDTO.getName());
//            classz.setAddress(classzDTO.getAddress());
//            classz.setSubjects(classzDTO.getSubjectDTOS().stream()
//                    .map(subjectDTO -> mapper.map(subjectDTO, Subject.class)).collect(Collectors.toList()));
//        }
//        classzRepository.save(classz);
//        tmp.setClassz(classz);
//        userRepository.save(tmp);
        return "đã thêm mới một học sinh";
    }

    @Override
    public String updateStudent(UserDTO dto) {
        return null;
    }

    @Override
    public String deleteStudent(int id) {
        if (!userRepository.existsById(id)) return "học sinh không tồn tại";
        userRepository.deleteById(id);
        return "đã xóa thành công";
    }
}
