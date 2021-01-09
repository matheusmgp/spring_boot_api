package com.mgptech.api.myrestapi.services.mapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;



@Component("ObjectMapperUtils")
public class ObjectMapperUtils {


    /**
     * Model mapper.
     */
    protected ModelMapper modelMapper;

    /**
     * Default Constructor.
     */
    public ObjectMapperUtils() {
        this.modelMapper = new ModelMapper();
    }
    
    /**
     * Maps the source to destination class.
     *
     * @param source    Source.
     * @param destClass Destination class.
     * @return Instance of destination class.
     */
    public <S, D> D mapTo(S source, Class<D> destClass) {
        return this.modelMapper.map(source, destClass);
    }
    
    /**
     * Converts the source list to a destination list mapping the source items to
     * destination type items.
     *
     * @param source    Source items.
     * @param destClass Destination class.
     * @return List of instances of destination type.
     */
    public <S, D> List<D> toList(List<S> source, Type destClass) {
        return this.modelMapper.map(source, destClass);
    }
}