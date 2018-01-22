package vip.itlearning.model.jpa;

import java.util.Date;

public interface Auditable {

    String getCreatedBy();

    Date getCreatedDate();

    String getLastModifiedBy();

    Date getLastModifiedDate();
}
