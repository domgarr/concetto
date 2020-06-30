package com.example.concetto.services;

import com.example.concetto.api.v1.model.SubjectDTO;
import com.example.concetto.models.Subject;

import java.util.List;

public interface SubjectService {
    SubjectDTO save (Subject subject);
    List<SubjectDTO> findAllDtoByUserId(Long id);
    List<Subject> findAllByUserId(Long id);
    SubjectDTO findById(Long id);
    int incrementCount(Long id);
    Long findUserIdById(Long id);
    List<Subject> findAllWhereLastUpdateIsInPast(Long userId);
    List<Subject> saveAll(List<Subject> subjects);
}
