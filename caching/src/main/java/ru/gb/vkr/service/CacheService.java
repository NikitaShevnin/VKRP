package ru.gb.vkr.service;

import org.springframework.stereotype.Service;
import ru.gb.vkr.model.CachedDataModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
;

@Service
public class CacheService {

    /**
     * Получает данные из кэша, если они там есть.
     * Иначе вызывает метод для получения данных и кэширует их.
     * @param id Идентификатор данных
     * @return Кэшированные данные
     */
    @Cacheable(value = "cachedData", key = "#id")
    public CachedDataModel getData(Long id) {
        // Вызов метода для получения данных, которые не находятся в кэше
        return loadDataFromSource(id);
    }

    /**
     * Обновляет данные в кэше.
     * @param id Идентификатор данных
     * @param data Новые данные
     * @return Обновленные данные
     */
    @CachePut(value = "cachedData", key = "#id")
    public CachedDataModel updateData(Long id, CachedDataModel data) {
        // Обновление данных в источнике данных
        updateDataInSource(id, data);
        return data;
    }

    /**
     * Удаляет данные из кэша.
     * @param id Идентификатор данных
     */
    @CacheEvict(value = "cachedData", key = "#id")
    public void deleteData(Long id) {
        // Удаление данных из источника данных
        deleteDataFromSource(id);
    }

    /**
     * Метод для получения данных из источника данных (например, базы данных).
     * В реальном приложении этот метод будет содержать логику для загрузки данных.
     *
     * @param id Идентификатор данных
     * @return Загруженные данные
     */
    private CachedDataModel loadDataFromSource(Long id) {
        // Код для загрузки данных из источника
        return new CachedDataModel(id, "Data for ID " + id);
    }

    /**
     * Метод для обновления данных в источнике данных (например, базе данных).
     * В реальном приложении этот метод будет содержать логику для обновления данных.
     * @param id Идентификатор данных
     * @param data Новые данные
     */
    private void updateDataInSource(Long id, CachedDataModel data) {
        // Код для обновления данных в источнике
    }

    /**
     * Метод для удаления данных из источника данных (например, базы данных).
     * В реальном приложении этот метод будет содержать логику для удаления данных.
     * @param id Идентификатор данных
     */
    private void deleteDataFromSource(Long id) {
        // Код для удаления данных из источника
    }
}

