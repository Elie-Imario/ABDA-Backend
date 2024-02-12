/*----INSERT TRIGGER -----*/
CREATE OR REPLACE FUNCTION Inscription_log_insert() RETURNS TRIGGER AS
'
    BEGIN
        INSERT INTO audit_inscription(action_type,matricule,nom,old_droit_inscription,new_droit_inscription,utilisateur)
        VALUES(''INSERT'', new.matricule, new.nom, null, new.droit_inscription,USER);
        RETURN NEW;
    END;
'
    LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER inscription_insert_trigger AFTER INSERT ON inscription
    FOR EACH ROW EXECUTE PROCEDURE Inscription_log_insert();
/*<---- ~ ----->*/

/*---- UPDATE TRIGGER -----*/
CREATE OR REPLACE FUNCTION Inscription_log_update() RETURNS TRIGGER AS
'
    BEGIN
        INSERT INTO audit_inscription(action_type,matricule,nom,old_droit_inscription,new_droit_inscription,utilisateur)
        VALUES(''UPDATE'', new.matricule, new.nom, old.droit_inscription, new.droit_inscription,USER);
        RETURN NEW;
    END;
'
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER inscription_update_trigger AFTER UPDATE ON inscription
    FOR EACH ROW WHEN ( OLD.* IS DISTINCT FROM NEW.* )  EXECUTE PROCEDURE Inscription_log_update();
/*<---- ~ ----->*/


/*---- DELETE TRIGGER -----*/
CREATE OR REPLACE FUNCTION Inscription_log_delete() RETURNS TRIGGER AS
'
BEGIN
    INSERT INTO audit_inscription(action_type,matricule,nom,old_droit_inscription,new_droit_inscription,utilisateur)
    VALUES(''DELETE'', old.matricule, old.nom, old.droit_inscription, null,USER);
    RETURN NEW;
END;
'
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER inscription_delete_trigger AFTER DELETE ON inscription
    FOR EACH ROW EXECUTE PROCEDURE Inscription_log_delete();
/*<---- ~ ----->*/
