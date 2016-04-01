import java.util.List;


public interface Basket {
        void addProduct(String product, int quantiti);//добавить продукт (название, количество)
        void removeProduct(String product);// удалить продукт (название)
        void updateProductQuantity(String product, int quantiti);//обновить количество продукта
        void clear();//очистить
        List<String> getProducts();//получить продукты
        int getProductQuantity(String product);//получить количество определённого продукта
}
