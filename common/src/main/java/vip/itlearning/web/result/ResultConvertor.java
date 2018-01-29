//package vip.itlearning.web.result;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import vip.itlearning.dto.result.ListResultDTO;
//import vip.itlearning.dto.result.PageResultDTO;
//import vip.itlearning.dto.result.ResultDTO;
//
//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * @author yaw
// * @date 2018/1/26 14:35
// */
//public abstract class ResultConvertor<Model, DTO>  {
//
//    public DTO toDTO(Model model) {
//        return this.toDTO(model, false);
//    }
//
//    public abstract DTO toDTO(Model var1, boolean var2);
//
//    public List<DTO> toListDTO(List<Model> modelList, Function<Model, DTO> toDTOMapper) {
//        return (List)modelList.stream().map(toDTOMapper).collect(Collectors.toList());
//    }
//
//    public final List<DTO> toListDTO(List<Model> modelList) {
//        List<DTO> dtoList = (List)modelList.stream().map((model) -> {
//            return this.toDTO(model, true);
//        }).collect(Collectors.toList());
//        return dtoList;
//    }
//
//    public final Page<DTO> toPageResult(Page<Model> modelPage, Function<Model, DTO> toDTOMapper) {
//        List<Model> modelList = modelPage.getContent();
//        List<DTO> dtoList = this.toListDTO(modelList, toDTOMapper);
//        long totalElements = modelPage.getTotalElements();
//        Page<DTO> dtoPage = new PageImpl(dtoList, this.getPageable(modelPage), totalElements);
//        return dtoPage;
//    }
//
//    public final Page<DTO> toPageResult(Page<Model> modelPage) {
//        List<Model> modelList = modelPage.getContent();
//        List<DTO> dtoList = this.toListDTO(modelList);
//        long totalElements = modelPage.getTotalElements();
//        Page<DTO> dtoPage = new PageImpl(dtoList, this.getPageable(modelPage), totalElements);
//        return dtoPage;
//    }
//
//    public final Result<DTO> toResult(Model model, Function<Model, DTO> toDTOMapper) {
//        DTO dto = toDTOMapper.apply(model);
//        Result<DTO> result = Result.success(dto);
//        return result;
//    }
//
//    public final Result<DTO> toResult(Model model) {
//        DTO dto = model == null ? null : this.toDTO(model);
//        Result<DTO> result = Result.success(dto);
//        return result;
//    }
//
//    public final ListResult<DTO> toResult(List<Model> modelList, Function<Model, DTO> toDTOMapper) {
//        List<DTO> dtoList = this.toListDTO(modelList, toDTOMapper);
//        ListResult<DTO> result = ListResult.success(dtoList);
//        return result;
//    }
//
//    public final ListResult<DTO> toResult(List<Model> modelList) {
//        List<DTO> dtoList = this.toListDTO(modelList);
//        ListResult<DTO> result = ListResult.success(dtoList);
//        return result;
//    }
//
//    public final PageResult<DTO> toResult(Page<Model> modelPage, Function<Model, DTO> toDTOMapper) {
//        List<DTO> dtoList = this.toListDTO(modelPage.getContent(), toDTOMapper);
//        PageResult<DTO> Result = PageResult.success(dtoList, modelPage);
//        return Result;
//    }
//
//    public final PageResult<DTO> toResult(Page<Model> modelPage) {
//        List<DTO> dtoList = this.toListDTO(modelPage.getContent());
//        PageResult<DTO> result = PageResult.success(dtoList, modelPage);
//        return result;
//    }
//
//    protected Pageable getPageable(Page<Model> modelPage) {
//        try {
//            Field pageableField = PageImpl.class.getSuperclass().getDeclaredField("pageable");
//            pageableField.setAccessible(true);
//            return (Pageable)pageableField.get(modelPage);
//        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var3) {
//            return null;
//        }
//    }
//}
