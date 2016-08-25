package com.whitehobbit.Addrbook.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by whitehobbit on 2016. 8. 25..
 */
@Data
public class AddrbookForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_name;
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_email;
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_tel;
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_birth;
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_comdept;
    @NotNull
    @Size(min = 1, max = 127)
    private String ab_memo;


}