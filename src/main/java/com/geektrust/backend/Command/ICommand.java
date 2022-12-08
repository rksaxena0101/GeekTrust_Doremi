package com.geektrust.backend.Command;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}