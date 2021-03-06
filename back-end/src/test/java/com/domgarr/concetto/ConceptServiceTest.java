package com.domgarr.concetto;

import com.domgarr.concetto.api.v1.mapper.ConceptMapper;
import com.domgarr.concetto.api.v1.model.ConceptDTO;
import com.domgarr.concetto.exception.NotFoundException;
import com.domgarr.concetto.models.Concept;
import com.domgarr.concetto.repositories.ConceptRepository;
import com.domgarr.concetto.services.ConceptService;
import com.domgarr.concetto.services.ConceptServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


public class ConceptServiceTest {
    private ConceptService conceptService;
    @Mock
    private ConceptRepository conceptRepository;


    //TODO: The following should only be instantiated once.
    @BeforeEach
    void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        conceptService = new ConceptServiceImpl(ConceptMapper.INSTANCE, conceptRepository);
    }

    //TODO: Use Mock Repository to test.
    @Test
    public void getAllConcepts_WhenConceptRepositoryFindsTwoConcepts_shouldReturnTwoConcepts() throws Exception {

        List<Concept> concepts = Arrays.asList(new Concept(), new Concept());

        when(conceptRepository.findAll()).thenReturn(concepts);

        //when
        List<ConceptDTO> conceptDTOS = conceptService.getAllConcepts();

        //then
        assertEquals(2, conceptDTOS.size());
    }

    @Test
    public void getAllConcepts_WhenConceptByIdIsNotFound_NotFoundExceptionIsThrown() {
        Optional<Concept> conceptOptional = Optional.empty();

        when(conceptRepository.findById(anyLong())).thenReturn(conceptOptional);

        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> conceptService.findDtoById(1L));

        assertTrue(thrown.getMessage().contains("Concept not found."));
    }

    @Test
    public void findDtoById_FindCreatedConceptUsingId_ShouldReturnANonNullObject(){
        Concept concept = new Concept();
        concept.setId(1L);
        concept.setName("Blah");

        Optional<Concept> optionalConcept = Optional.of(concept);


        when(conceptRepository.findById(1L)).thenReturn(optionalConcept);
        assertNotNull(conceptService.findDtoById(1L));

    }

}
