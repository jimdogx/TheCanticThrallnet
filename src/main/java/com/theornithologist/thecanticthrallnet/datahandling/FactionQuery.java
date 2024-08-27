package com.theornithologist.thecanticthrallnet.datahandling;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactionQuery {

    private static final String URL = "jdbc:sqlite:src/main/resources/com/theornithologist/thecanticthrallnet/data/munitorum.db";

    public String getArmyRuleName(String faction) {
        String sql = "SELECT name FROM Abilities where faction_id ='" + faction + "'";
        try (var conn = DriverManager.getConnection(URL);
             var stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            return rs.getString(1);
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public String getArmyRule(String faction) {
        String sql = "SELECT description FROM Abilities where faction_id ='" + faction + "'";
        try (var conn = DriverManager.getConnection(URL);
             var stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            return rs.getString(1);
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public ResultSet getDetachment(String faction) {
        String sql = "SELECT DISTINCT detachment FROM Detachment_abilities where faction_id ='" + faction + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public ResultSet getDetachmentAbilities(String faction, String detachmentName) {
        String sql = "SELECT name, legend, description FROM Detachment_abilities where faction_id ='" + faction + "' AND detachment ='" + detachmentName +"'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public ResultSet getStratagems(String detachment) {
        String sql = "SELECT name, type, cp_cost, legend, turn, phase, description FROM Stratagems where detachment ='" + detachment +"'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public ResultSet getEnhancements(String detachment) {
        String sql = "SELECT name, legend, description, cost FROM Enhancements where detachment ='" + detachment +"'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheet(String faction) {
        String sql = "SELECT id, name, legend, role, loadout, transport, virtual, leader_footer," +
                "damaged_w, damaged_description FROM Datasheets where faction_id ='" + faction + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetAbilities(String datasheetID) {
        String sql = "SELECT line, ability_id, name, description, type," +
                " parameter FROM Datasheets_abilities where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetKeywords(String datasheetID) {
        String sql = "SELECT keyword, model, is_faction_keyword FROM Datasheets_keywords where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetLeaders(String datasheetID) {
        String sql = "SELECT attached_id FROM Datasheets_leader where leader_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetModels(String datasheetID) {
        String sql = "SELECT line, name, M, T, Sv, inv_sv," +
                "  inv_sv_descr, W, Ld, OC, base_size, base_size_descr " +
                "FROM Datasheets_models where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetModelsCost(String datasheetID) {
        String sql = "SELECT line, description, cost FROM Datasheets_models_cost where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetOptions(String datasheetID) {
        String sql = "SELECT line, button, description FROM Datasheets_options where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetUnitComposition(String datasheetID) {
        String sql = "SELECT line, description FROM Datasheets_unit_composition where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getDatasheetWargear(String datasheetID) {
        String sql = "SELECT line, line_in_wargear, dice, name, " +
                "description, range, type, A, BS_WS, S, AP, D" +
                " FROM Datasheets_wargear where datasheet_id ='" + datasheetID + "'";
        try {
            var conn = DriverManager.getConnection(URL);
            var stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

