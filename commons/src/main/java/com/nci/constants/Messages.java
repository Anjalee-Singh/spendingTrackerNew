package com.nci.constants;


import java.util.function.Supplier;

/**
 * Commonly used messages (error or informational) for Schema API.
 *
 */
public interface Messages {

	String ERR_CREATING_DATABASE = "Error creating database [%s]";

	String ERR_CREATING_DB_COLLECTION = "Error creating document collection with id [%s]";

	Supplier<String> ERR_FETCHING_RESULT = () -> "Error fetching result";

	Supplier<String> ERR_FETCHING_MAX_VER = () -> "Error fetching max version";

	Supplier<String> ERR_VALIDATING_SCHEMA = () -> "Error while validating schema";

	Supplier<String> ERR_FETCHING_SCHEMA_COUNT = () -> "Error fetching count of schemas";

	String ERR_SCHEMA_NOT_EXIST = "Schema [%s] does not exist";

	String ERR_INVALID_DELETE_KEY = "Invalid delete key [%s] specified";

	Supplier<String> SCHEMA_INVALID = () -> "Supplied schema is invalid OR does not exist";

	Supplier<String> ERR_INVALID_COLLECTION_ID = () -> "Collection ID cant be null or empty";

	String DUPLICATE_ERR = "Supplied %s is not unique";

	Supplier<String> INVALID_INPUT_ERR = () -> "Invalid input format";

	Supplier<String> NO_DATA_AVAILABLE = () -> "No data available";

	String NO_RECORD_FOUND = "No %s found";

	Supplier<String> DATABASE_EXCEPTION = () -> "Database Exception";

	Supplier<String> LOCK_TIMEOUT = () -> "Timed out waiting for lock to update";

	String VALIDATION_MANDATORY_MISSING = "Mandatory field(s) [%s] missing";


	String BULK_REQUEST_LIMIT_EXCEEDED = "Request limit exceeded with size [%s]. Maximum allowed is [%s]";

	String SCHEMA_UPSERT_REASON = "Attempted '%s' schemas: inserted '%s' schemas, updated '%s' schemas, '%s' failed";

	Supplier<String> ERR_POSTING_SCHEMA = () -> "Error while posting schema";

	String DV_INVALIDATE_FAIL = "Could not invalidate DV";

	String VALIDATION_SUCCESSFUL = "Validation successful";

	String INVALID_CACHE_TYPE = "Specified type does not exist, allowed values ";

	String CACHE_INVALIDATED = "Cache invalidation successful for [%s]";

	String SCHEMA_METADATA_UNAVAILABLE = "Schema metadata not available for [%s]";

	String SRC_DEST_ENTITY_MISMATCH = "Mismatch between provided [%s] and reference [%s] %s";

	String DELETE_SCHEMA = "%s [%s] successfully deleted";

	Supplier<String> OP_NOT_SUPPORTED_ERROR = () -> "Operation not supported";

	String CREATE_SAMPLE_SUCCESSFUL = "Sample %s successfully created for [%s] against version [%s]";

	String UPSERT_SAMPLE_MISMATCH = "Mismatch between URI [%s] and body [%s] %s";


	String ERR_DELETE_SCHEMA_COLL_ACTIVE_SCHEMA = "%s schema collection has active schema(s). Please delete them first and re-try";

	String ERR_DELETING_SCHEMA_COLL = "Error deleting schema collection [%s]";


	String ERR_VALIDATION_UPSERT_SCHEMA = VALIDATION_MANDATORY_MISSING + " for %s schema(s)";

	String INVALID_SCHEMA_TYPE = "Supplied schema type is not valid. Allowed %s";

	Supplier<String> ERR_ENDPOINT_DISABLED = () -> "Endpoint is disabled for this environment";

	String RULE_EVAL_REPORT = "Total Rule(s): %s, Evaluation Result [Specific: %s, Generic: %s], final result [%s]";

	String ERR_READING_FILE_SHARE = "Error reading file share %s";

	Supplier<String> NO_SCHEMA_PRESENT_FOR_SYNC = () -> "No schemas found for the supplied criteria to sync";

	Supplier<String> STORAGE_ACCOUNT_ERROR = () -> "Failed to retrieve file storage account";
}