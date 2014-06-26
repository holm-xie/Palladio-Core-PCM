package edu.kit.ipd.sdq.eventsim.system.entities;

import org.apache.log4j.Logger;
import org.osgi.service.useradmin.User;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.debug.DebugEntityListener;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.IUser;

/**
 * This entity represents the execution of a system call, which has been issued by a {@link User}.
 * 
 * @author Philipp Merkle
 * 
 * @see EventSimEntity
 */
public class Request extends EventSimEntity implements IRequest {

    private static final Logger logger = Logger.getLogger(Request.class);

    /** the user that has issued the request */
    private final IUser user;

    /** the system call that is to be simulated by this request */
    private final EntryLevelSystemCall call;
    
    private RequestState state;

    /**
     * the request context is a unique identifier for this Request, which is required for the Probe
     * Specification.
     */
    private RequestContext requestContext;

    /**
     * the activation event encapsulates the bahaviour that is to be performed when this Request is
     * activated after it has been passivated before (see also: activate and passivate methods).
     */
    private AbstractSimEventDelegator<Request> activationEvent;

    /**
     * Constructs a new Request representing the execution of the specified system call, which has
     * been issued by the given User.
     * 
     * @param model
     *            the simulation model
     * @param call
     *            the system call
     * @param user
     *            the User that has issued the Request
     */
    public Request(final AbstractEventSimModel model, final EntryLevelSystemCall call, final IUser user) {
        super(model, "Request");
        this.call = call;
        this.user = user;

        // install debug listener, if debugging is enabled
        if (logger.isDebugEnabled()) {
            this.addEntityListener(new DebugEntityListener(this));
        }
    }

    protected RequestContext createRequestContext() {
        // set the request context of this request. As this entity's ID is unique, we can use it to
        // construct the request context
        RequestContext parentContex = this.user.getRequestContext();
        return new RequestContext(Long.toString(this.getEntityId()), parentContex);
    }

    /**
     * Returns the user that has issued this Request.
     * 
     * @return the user
     */
    public IUser getUser() {
        return this.user;
    }

    /**
     * Returns the system call that is to be executed by this Request.
     * 
     * @return the system call
     */
    public EntryLevelSystemCall getSystemCall() {
        return this.call;
    }

    /**
     * Returns the RequestContext required by the Probe Specification to identify this Request.
     * 
     * @return a unique identifier, encapsulated in a RequestContext, for this Request
     */
    @Override
    public RequestContext getRequestContext() {
        if (this.requestContext == null) {
            this.requestContext = createRequestContext();
        }
        return this.requestContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Request#" + this.getEntityId() + " of " + this.getUser().getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Call this method when the simulated process (see: {@code getSimulatedProcess()} method) has
     * been scheduled on a resource and waits for being serviced. The specified activationEvent will
     * be scheduled as soon as the simulated process has been activated.
     * 
     * @param activationEvent
     *            the event that is to be scheduled when the simulated process has been activated
     */
    @SuppressWarnings("unchecked")
	public void passivate(AbstractSimEventDelegator<?> activationEvent) {
        assert (activationEvent != null) : "The argument activationEvent may not be null";
        this.activationEvent = (AbstractSimEventDelegator<Request>) activationEvent;
    }

    /**
     * Activates this Request by scheduling the activationEvent passed to the {@code passivate}
     * method. The Request must have been passivated before.
     * 
     * @see #passivate(AbstractSimEventDelegator)
     */
    public void activate() {
        if (this.activationEvent == null) {
        	// TODO reactive output (disabled it for performance measurements)
        	//if(logger.isEnabledFor(Level.WARN))
        	//	logger.warn("Tried to activate request " + this.getName() + ", but there is no activation event.");
            return;
        }

        // schedule the activation event...
        this.activationEvent.schedule(this, 0);

        // ...and clear the event thereafter
        this.activationEvent = null;
    }

	public RequestState getRequestState() {
		return state;
	}

	public void setRequestState(RequestState state) {
		this.state = state;
	}

	@Override
	public long getId() {
		return getEntityId();
	}

}
