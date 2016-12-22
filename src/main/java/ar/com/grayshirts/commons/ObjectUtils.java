package ar.com.grayshirts.commons;

import org.apache.commons.lang3.StringUtils;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Utils method to work with any object.
 */
public abstract class ObjectUtils {

    /**
     * Determine if a give object is unique by some field value. A function to find the value in somewhere
     * place must be provided.
     * @param obj the object to test, the class must have implemented the `equals` method.
     * @param idFieldVal the value of the field to test with
     * @param findByFieldFunction a function that allows find any object with `field=idFieldVal`
     * @return <code>true</code> if the element is unique
     */
    public static boolean isUnique(Object obj, String idFieldVal, Function<String, Object> findByFieldFunction) {
        return Stream.of(idFieldVal)
                     .filter(StringUtils::isNotEmpty)
                     .map(findByFieldFunction)
                     .filter(obj2->obj2!=null && !obj2.equals(obj)).count()==0;
    }

    /**
     * Determine if a give object is NOT unique by some field value. A function to find the value in somewhere
     * place must be provided.
     * @param obj the object to test, the class must have implemented the `equals` method.
     * @param idFieldVal the value of the field to test with
     * @param findByFieldFunction a function that allows find any object with `field=idFieldVal`
     * @return <code>true</code> if the element is NOT unique
     */
    public static boolean isNotUnique(Object obj, String idFieldVal, Function<String, Object> findByFieldFunction) {
        return !isUnique(obj, idFieldVal, findByFieldFunction);
    }
}
