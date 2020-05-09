package com.project.copypasteapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.copypasteapi.Bean.CopyPasteBean;

@Repository
public interface CopyPasteApiRerpository extends JpaRepository<CopyPasteBean, String> {

}
