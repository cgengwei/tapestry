package com.inspi01.domain.base;

public interface AuditorAware {

    public static final String DEFAULT_AUDITOR = "system";

    void audit(String auditor);

}
