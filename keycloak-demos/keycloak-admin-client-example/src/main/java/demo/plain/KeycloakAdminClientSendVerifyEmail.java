package demo.plain;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.Arrays;
import java.util.List;

public class KeycloakAdminClientSendVerifyEmail {

    public static void main(String[] args) {

        String serverUrl = "http://localhost:8081/auth";
        String realm = "action-token-expired";
        // idm-client needs to allow "Direct Access Grants: Resource Owner Password Credentials Grant"
        String clientId = "iam-helper";
        String clientSecret = "17e2017f-6db6-4a1e-b321-a41ffa25a092";

//		// Client "iam-helper" needs service-account with at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(serverUrl) //
                .realm(realm) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(clientId) //
                .clientSecret(clientSecret).build();

        String userId="7f718d58-09e2-4228-a66b-53c16088be0f";
        UserResource userResource = keycloak.realm(realm).users().get(userId);
        userResource.executeActionsEmail(Arrays.asList("VERIFY_EMAIL"));

//        String username = "tester";
//        List<UserRepresentation> users = keycloak.realm(realm).users().search(username);
//        if (!users.isEmpty()) {
//            for (UserRepresentation userRep : users) {
//                if (userRep.getUsername().equals(username)) {
//                    UserRepresentation user = users.get(0);
//                    keycloak.realm(realm).users().get(user.getId()).executeActionsEmail(Arrays.asList("VERIFY_EMAIL"));
//                    break;
//                }
//            }
//        }


//        // User "idm-admin" needs at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
//        Keycloak keycloak = KeycloakBuilder.builder() //
//                .serverUrl(serverUrl) //
//                .realm(realm) //
//                .grantType(OAuth2Constants.PASSWORD) //
//                .clientId(clientId) //
//                .clientSecret(clientSecret) //
//                .username("idm-admin") //
//                .password("admin") //
//                .build();
//
//        // Define user
//        UserRepresentation user = new UserRepresentation();
//        user.setEnabled(true);
//        user.setUsername("tester1");
//        user.setFirstName("First");
//        user.setLastName("Last");
//        user.setEmail("tom+tester1@tdlabs.local");
//        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));
//
//        // Get realm
//        RealmResource realmResource = keycloak.realm(realm);
//        UsersResource usersRessource = realmResource.users();
//
//        // Create user (requires manage-users role)
//        Response response = usersRessource.create(user);
//        System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
//        System.out.println(response.getLocation());
//        String userId = CreatedResponseUtil.getCreatedId(response);
//
//        System.out.printf("User created with userId: %s%n", userId);
//
//        // Define password credential
//        CredentialRepresentation passwordCred = new CredentialRepresentation();
//        passwordCred.setTemporary(false);
//        passwordCred.setType(CredentialRepresentation.PASSWORD);
//        passwordCred.setValue("test");
//
//        UserResource userResource = usersRessource.get(userId);
//
//        // Set password credential
//        userResource.resetPassword(passwordCred);
//
////        // Get realm role "tester" (requires view-realm role)
//        RoleRepresentation testerRealmRole = realmResource.roles()//
//                .get("tester").toRepresentation();
////
////        // Assign realm role tester to user
//        userResource.roles().realmLevel() //
//                .add(Arrays.asList(testerRealmRole));
////
////        // Get client
//        ClientRepresentation app1Client = realmResource.clients() //
//                .findByClientId("app-frontend-springboot").get(0);
////
////        // Get client level role (requires view-clients role)
//        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
//                .roles().get("user").toRepresentation();
////
////        // Assign client level role to user
//        userResource.roles() //
//                .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
//
//        // Send password reset E-Mail
//        // VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS
////        usersRessource.get(userId).executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));
//
//        // Delete User
////        userResource.remove();
    }
}
