package ar.com.grayshirts.commons.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.lang.Math.min;

/**
 * DTO class to paging a collection of data.
 * @param <T> the element class inside the collection.
 */
public class Page<T> implements Serializable {

    private Collection<T> items;
    private Paging paging;

    public Page() { }

    public Page(Collection<T> items) {
        this.items = items;
        this.paging = new Paging(items.size());
    }

    public Page(Collection<T> items, Integer offset, Integer limit, Integer total) {
        this.items = items;
        this.paging = new Paging(offset,limit,total);
    }

    /**
     * Creates a pagination iterating all the objects and creating the corresponding subset.
     * NOTE: It's recommended for performance issues to avoid this way if you can paginate the result from the
     * datastore itself.
     */
    public static <M> Page<M> paginate(Collection<M> items, Integer offset, Integer limit) {
        List<M> l;
        if (items instanceof List) {
            l = (List<M>) items;
        } else {
            l = (List<M>) Arrays.asList(items.toArray());
        }
        List<M> limitedData = l.subList(min(offset!=null?offset:0, items.size()),
            min(items.size(), (offset!=null?offset:0) + (limit!=null?limit: items.size())));
        return new Page<>(limitedData, offset, limit, items.size());
    }

    public Collection<T> getItems() {
        return items;
    }
    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public static class Paging implements Serializable {

        private Integer offset;
        private Integer limit;
        private Integer total;

        public Paging() { }

        public Paging(Integer total) {
            this.total = total;
        }

        public Paging(Integer offset, Integer limit, Integer total) {
            this.offset = offset;
            this.limit = limit;
            this.total = total;
        }

        public Integer getOffset() {
            return offset;
        }
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getLimit() {
            return limit;
        }
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getTotal() {
            return total;
        }
        public void setTotal(Integer total) {
            this.total = total;
        }
    }
}
