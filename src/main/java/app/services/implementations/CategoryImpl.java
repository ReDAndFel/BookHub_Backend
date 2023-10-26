package app.services.implementations;

import app.dtos.CategoryDTO;
import app.model.Category;
import app.services.interfaces.CategoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryInterface {
    @Override
    public Category getCategory(int idCategory) throws Exception {
        return null;
    }

    @Override
    public CategoryDTO getCategoryDTO(int idCategory) throws Exception {
        return null;
    }

    @Override
    public List<CategoryDTO> listAllCategory() {
        return null;
    }
}
