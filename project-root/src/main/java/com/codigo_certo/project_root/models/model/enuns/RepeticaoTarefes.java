package com.codigo_certo.project_root.models.model.enuns;

public enum RepeticaoTarefes {


        UMA_VEZ_POR_DIA(1,"Uma vez por dia"),
        UMA_VEZ_POR_DIA_SEGUNDA_SEXTA(2,"Uma vez por dia(segunda-sexta)"),
        UMA_VEZ_POR_SEMANA(3,"Uma vez por semana"),
        UMA_VEZ_POR_MES(4,"Uma vez por_mês"),
        UMA_VEZ_POR_ANO(5,"Uma vez por ano");

        private Integer codRepeticao;
        private String descricao;

        RepeticaoTarefes(Integer codRepeticao, String descricao) {
                this.codRepeticao = codRepeticao;
                this.descricao = descricao;
        }

        public Integer getCodRepeticao() {
                return codRepeticao;
        }

        public String getDescricao() {
                return descricao;
        }

}
