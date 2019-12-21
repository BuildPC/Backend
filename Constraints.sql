/* Triggers */
DELIMITER //

CREATE TRIGGER assign_Basket
AFTER INSERT ON users FOR EACH ROW
BEGIN
  IF new.email IS NOT NULL THEN INSERT INTO Basket(username) VALUES(new.email);
  END IF;
END; //

DELIMITER ;


DELIMITER //

CREATE TRIGGER check_Stock
BEFORE INSERT ON BContains FOR EACH ROW
BEGIN
	DECLARE val INT;
    IF NEW.item_id IN (SELECT I.item_id
    				FROM Item I
                    WHERE NEW.item_id = I.item_id AND NEW.amount <= I.stock) THEN SET val = 1;
    ELSE SET new.item_id = NULL;
    END IF;
END //

DELIMITER ;

/* Procedures */
DELIMITER //

CREATE PROCEDURE addBasket(IN username VARCHAR(255), IN itemID INT,IN amount INT)
BEGIN
	DECLARE basketId INT;
    
    SELECT MAX(B.basket_id)
    INTO basketId
    FROM Basket B 
    WHERE B.username = username;
    
    IF itemID NOT IN (SELECT B.item_id FROM BContains B WHERE B.basket_id = basketId AND B.item_id = itemID ) THEN INSERT INTO BContains (amount,basket_id,item_id) VALUES (amount,basketID,itemID);
    ELSE UPDATE BContains SET amount = amount WHERE item_id = itemID AND basket_id = basketId;
    END IF;
END //

DELIMITER ;