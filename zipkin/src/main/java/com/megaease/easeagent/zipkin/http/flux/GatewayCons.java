package com.megaease.easeagent.zipkin.http.flux;

public interface GatewayCons {

    String CURRENT_TRACE_CONTEXT_ATTR = GatewayCons.class.getName() + ".CurrentTraceContext";
    String TRACE_CONTEXT_ATTR = GatewayCons.class.getName() + ".TraceContext";
}
