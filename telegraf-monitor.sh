#!/bin/bash

wait_for_log_line() {
    container_name="$1"
    log_line="$2"
    
    while ! docker logs "$container_name" | grep -q "$log_line"; do
        sleep 5
    done
}

stop_container() {
    container_name="$1"
    docker stop "$container_name"
}
