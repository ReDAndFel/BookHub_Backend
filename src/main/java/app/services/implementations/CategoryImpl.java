package app.services.implementations;

import app.dtos.CategoryDTO;
import app.model.Category;
import app.repositories.CategoryRepo;
import app.services.interfaces.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryImpl implements CategoryInterface {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category getCategory(int idCategory) throws Exception {
        Category category = categoryRepo.findById(idCategory).get();
        return category;
    }

    @Override
    public CategoryDTO getCategoryDTO(int idCategory) throws Exception {
        Category category = categoryRepo.findById(idCategory).get();
        CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getNombre(), category.getIconFontAwesome());
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> listAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDTOList.add(convertToGetDTO(category));
        }

        return null;
    }

    private CategoryDTO convertToGetDTO(Category category) {

        CategoryDTO categoryDTO = new CategoryDTO(
                category.getId(),
                category.getNombre(),
                category.getIconFontAwesome()
        );

        return categoryDTO;
    }
}
