package vip.itlearning.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import vip.itlearning.dto.result.ListResultDTO;
import vip.itlearning.dto.result.PageResultDTO;
import vip.itlearning.dto.result.ResultDTO;
import vip.itlearning.model.jpa.Auditable;
import vip.itlearning.support.CurrentUserFactoryBean;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yaw
 * @date 2018/1/23 16:39
 */
public abstract class AbstractConvertor<Model, DTO> {
    @Autowired(
            required = false
    )
    protected CurrentUserFactoryBean currentUserFactoryBean;

    public AbstractConvertor() {
    }

    public abstract Model toModel(DTO var1);

    public DTO toDTO(Model model) {
        return this.toDTO(model, false);
    }

    public abstract DTO toDTO(Model var1, boolean var2);

    public final List<Model> toListModel(List<DTO> dtoList, Function<DTO, Model> toModelMapper) {
        List<Model> modelList = (List)dtoList.stream().map(toModelMapper).collect(Collectors.toList());
        return modelList;
    }

    public final List<Model> toListModel(List<DTO> dtoList) {
        List<Model> modelList = (List)dtoList.stream().map((dto) -> {
            return this.toModel(dto);
        }).collect(Collectors.toList());
        return modelList;
    }

    public List<DTO> toListDTO(List<Model> modelList, Function<Model, DTO> toDTOMapper) {
        return (List)modelList.stream().map(toDTOMapper).collect(Collectors.toList());
    }

    public final List<DTO> toListDTO(List<Model> modelList) {
        List<DTO> dtoList = (List)modelList.stream().map((model) -> {
            return this.toDTO(model, true);
        }).collect(Collectors.toList());
        return dtoList;
    }

    public final Page<DTO> toPageDTO(Page<Model> modelPage, Function<Model, DTO> toDTOMapper) {
        List<Model> modelList = modelPage.getContent();
        List<DTO> dtoList = this.toListDTO(modelList, toDTOMapper);
        long totalElements = modelPage.getTotalElements();
        Page<DTO> dtoPage = new PageImpl(dtoList, this.getPageable(modelPage), totalElements);
        return dtoPage;
    }

    public final Page<DTO> toPageDTO(Page<Model> modelPage) {
        List<Model> modelList = modelPage.getContent();
        List<DTO> dtoList = this.toListDTO(modelList);
        long totalElements = modelPage.getTotalElements();
        Page<DTO> dtoPage = new PageImpl(dtoList, this.getPageable(modelPage), totalElements);
        return dtoPage;
    }

    public final ResultDTO<DTO> toResultDTO(Model model, Function<Model, DTO> toDTOMapper) {
        DTO dto = toDTOMapper.apply(model);
        ResultDTO<DTO> resultDTO = ResultDTO.success(dto);
        return resultDTO;
    }

    public final ResultDTO<DTO> toResultDTO(Model model) {
        DTO dto = model == null ? null : this.toDTO(model);
        ResultDTO<DTO> resultDTO = ResultDTO.success(dto);
        return resultDTO;
    }

    public final ListResultDTO<DTO> toResultDTO(List<Model> modelList, Function<Model, DTO> toDTOMapper) {
        List<DTO> dtoList = this.toListDTO(modelList, toDTOMapper);
        ListResultDTO<DTO> resultDTO = ListResultDTO.success(dtoList);
        return resultDTO;
    }

    public final ListResultDTO<DTO> toResultDTO(List<Model> modelList) {
        List<DTO> dtoList = this.toListDTO(modelList);
        ListResultDTO<DTO> resultDTO = ListResultDTO.success(dtoList);
        return resultDTO;
    }

    public final PageResultDTO<DTO> toResultDTO(Page<Model> modelPage, Function<Model, DTO> toDTOMapper) {
        List<DTO> dtoList = this.toListDTO(modelPage.getContent(), toDTOMapper);
        PageResultDTO<DTO> resultDTO = PageResultDTO.success(dtoList, modelPage);
        return resultDTO;
    }

    public final PageResultDTO<DTO> toResultDTO(Page<Model> modelPage) {
        List<DTO> dtoList = this.toListDTO(modelPage.getContent());
        PageResultDTO<DTO> resultDTO = PageResultDTO.success(dtoList, modelPage);
        return resultDTO;
    }

    protected final void loadAuditToDTO(Auditable model, BaseEntityDTO dto) {
        dto.setCreatedBy(model.getCreatedBy());
        dto.setLastModifiedBy(model.getLastModifiedBy());
        dto.setCreatedDate(model.getCreatedDate());
        dto.setLastModifiedDate(model.getLastModifiedDate());
    }

    protected Pageable getPageable(Page<Model> modelPage) {
        try {
            Field pageableField = PageImpl.class.getSuperclass().getDeclaredField("pageable");
            pageableField.setAccessible(true);
            return (Pageable)pageableField.get(modelPage);
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var3) {
            return null;
        }
    }

    protected Object getCurrentUser() {
        return this.currentUserFactoryBean == null ? null : this.currentUserFactoryBean.getCurrentUser();
    }
}
