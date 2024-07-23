package com.myweb.firstboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImgmngDto {
	private int id;
	private String file_name;
	private String file_path;
	private String org_file_name;
	private int galary_id;
	private String userid;
	private String thumbnail;
}
