package vip.itlearning.model.jpa;

/**
 * @author yaw
 * @date 2018/1/22 15:19
 */

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * 抽象模型类
 * @author yaw
 * @date 2018/1/22 15:24
 */
@MappedSuperclass
public abstract class IdEntity implements Persistable<Long> {
    private static final long serialVersionUID = -4603175720586769550L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Persistable#getId()
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id the id to set
     */
    protected void setId(final Long id) {
        this.id = id;
    }

    /**
     * Must be {@link Transient} in order to ensure that no JPA provider
     * complains because of a missing setter.
     *
     * @see DATAJPA-622
     * @see Persistable#isNew()
     */
    @Override
    @Transient
    public boolean isNew() {
        return null == this.getId();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        final Persistable<?> that = (Persistable<?>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == this.getId() ? 0 : this.getId().hashCode() * 31;

        return hashCode;
    }
}