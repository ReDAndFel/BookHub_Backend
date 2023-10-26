package app.services.interfaces;

import app.dtos.CategoryDTO;
import app.model.Category;

import java.util.List;


public interface CategoryInterface {
    Category getCategory(int idCategory) throws Exception;
    CategoryDTO getCategoryDTO(int idCategory) throws Exception;
    List<CategoryDTO> listAllCategory();
}
