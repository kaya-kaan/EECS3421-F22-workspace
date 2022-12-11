SELECT client.client_name
FROM client
WHERE client.branch_id = (
	SELECT branch.branch_id
    FROM branch
    WHERE branch.mgr_id = 102
    LIMIT 1
    );