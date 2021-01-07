package com.mgptech.api.myrestapi.application.services;


import com.mgptech.api.myrestapi.application.IdentityDto;
import com.mgptech.api.myrestapi.domain.entities.BaseEntity;

import com.mgptech.api.myrestapi.services.interfaces.service.IBaseService;
/**
 * BaseService
 */
public class BaseService<TDto extends IdentityDto,TEntity extends BaseEntity> implements IBaseService<TDto,TEntity> {

    @Autowired
 /*   private ModelMapper modelMapper;
 
    private IBaseRepository<TEntity> _repository;
    
    public BaseService(IBaseRepository<TEntity> repository){
        this._repository = repository;
    }*/
    
    @Override
    public TDto GetById(long id) {
       /* Optional<TEntity> entity = this._repository.findById(id);
        if(entity.isPresent()){
            TDto dto = this.modelMapper.map(entity.get(), new TypeToken<TDto>(getClass()){}.getType());
            return dto;
        }else{
            return null;
        }*/
    }

    @Override
    public List<TDto> GetALL() {
       /* List<TEntity> entitys = this._repository.findAll();
        List<TDto> dtos = this.modelMapper.map(entitys, new TypeToken<List<TDto>>(getClass()){}.getType());
        return dtos;*/
    }

    @Override
    public TDto Create(TDto dto) {
        //return SaveEntity(dto);
    }
    
    private TDto SaveEntity(TDto dto){
       /* TEntity entity = this.modelMapper.map(dto, new TypeToken<TEntity>(getClass()){}.getType());
        this._repository.save(entity);
        Commit();
        return dto;*/
    }

    @Override
    public TDto Update(TDto dto) {
        //return SaveEntity(dto);
    }

    @Override
    public int Delete(long id) {
        /*this._repository.deleteById(id);
        return 1;*/
    }

    @Override
    public int Commit() {
      /*  this._repository.flush();
        return 1;*/
    }

    protected ModelMapper getModelMapper(){
       // return this.modelMapper;
    }
}
